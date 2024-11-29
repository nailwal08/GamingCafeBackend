@RestController
@RequestMapping("/session")
@Slf4j
public class AdminController {

	@Autowired
	private UserSessionService userSessionService;

	@Autowired
	private PersonalComputerService pcService;

	@PostMapping(value = "/start", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserSession> startSession(@RequestBody @Valid StartSessionRequest request) {

		log.info("Starting session for user: {} on PC ID: {}", request.getUserName(), request.getPcName());

		return new ResponseEntity<>(userSessionService.startSession(request.getPcName(), request.getUserName()),
				HttpStatus.CREATED);
	}

	/**
	 * request for startSession :{ "pcName" : "", "userName" : "" }
	 */

	@PostMapping("/end/{sessionId}/{pcName}")
	public ResponseEntity<Map<String, String>> endSession(@PathVariable Long sessionId, @PathVariable String pcName) {

		log.info("Ending session with ID: {} and pcName: {}", sessionId,pcName);

		UserSession session = userSessionService.endSession(sessionId,pcName);
		Map<String, String> sessionDetails = new HashMap<>();

		sessionDetails.put("User Name", session.getUserName());
		sessionDetails.put("Charges", String.valueOf(session.getCharges()));

		return ResponseEntity.ok(sessionDetails);
	}

	@PostMapping("/register")
	public ResponseEntity<PersonalComputer> registerPC(@RequestBody @Valid PersonalComputer pc) {
		PersonalComputer registeredPC = pcService.registerPC(pc);
		return ResponseEntity.ok(registeredPC);
	}

	/**
	 * register request: { "pcName" : "" }
	 */

	@GetMapping(value = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getAvailablePCs() {
		List<String> availablePCs = pcService.getAvailablePCs();
		return ResponseEntity.ok(availablePCs);
	}
}
