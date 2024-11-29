@Service
public class PersonalComputerServiceImpl implements PersonalComputerService {

    @Autowired
    private PersonalComputerRepo pcRepository;

    @Override
    public PersonalComputer registerPC(PersonalComputer pc) {
        if (pcRepository.existsByPcName(pc.getPcName())) {
            throw new RuntimeException("A PC with this name already exists");
        }

        pc.setAvailable(true);
        return pcRepository.save(pc);
    }

    @Override
    public List<String> getAvailablePCs() {
        return pcRepository.findByIsAvailable(true) // Fetch all available PCs
                     .stream()
                     .map(PersonalComputer::getPcName) // Extract pcName
                     .toList(); // Collect as a list
    }
}
