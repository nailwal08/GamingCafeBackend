@Service
public class UserServiceSessionImpl implements UserSessionService {

	@Autowired
	private UserSessionRepo userSessionRepository;

	@Autowired
	private PersonalComputerRepo pcRepository;

	@Override
	public UserSession startSession(String pcName, String userName) {

		PersonalComputer pc = pcRepository.findByPcName(pcName);
		if (pc == null) {
			throw new RuntimeException("PC not found");
		}
		if (!pc.isAvailable()) {
			throw new RuntimeException("PC is not available");
		}

		pc.setAvailable(false);
		UserSession session = new UserSession();
		session.setPc(pc);
		session.setUserName(userName);
		session.setStartTime(LocalDateTime.now());
		session.setActive(true);

		return userSessionRepository.save(session);
	}

	@Override
	public UserSession endSession(Long sessionId, String pcName) {
		UserSession session = userSessionRepository.findById(sessionId)
				.orElseThrow(() -> new RuntimeException("Session not found"));

		PersonalComputer pc = pcRepository.findByPcName(pcName);
		pc.setAvailable(true);

		session.setEndTime(LocalDateTime.now());
		session.setActive(false);

		// Calculate duration in seconds
		session.setDuration(java.time.Duration.between(session.getStartTime(), session.getEndTime()).getSeconds());

		// Calculate charges (assuming a fixed rate per second, e.g., $0.05)
		double ratePerSecond = 0.05;
		session.setCharges(session.getDuration() * ratePerSecond);

		return userSessionRepository.save(session);
	}

}
