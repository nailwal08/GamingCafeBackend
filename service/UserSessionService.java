public interface UserSessionService {

	
	UserSession startSession(String pcName, String userName);
    UserSession endSession(Long sessionId, String pcName);
}
