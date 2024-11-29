@Repository
public interface PersonalComputerRepo extends JpaRepository<PersonalComputer, String> {

	List<PersonalComputer> findByIsAvailable(boolean isAvailable);

	boolean existsByPcName(String pcName);

	PersonalComputer findByPcName(String pcName);
}
