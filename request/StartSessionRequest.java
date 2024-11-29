@Getter
@Setter
public class StartSessionRequest {

	@NotNull(message = "PC ID must not be null")
	private String pcName;

	@NotNull(message = "User name must not be null")
	private String userName;

}
