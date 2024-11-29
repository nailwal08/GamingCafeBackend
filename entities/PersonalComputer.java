@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalComputer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "PC name cannot be blank")
	private String pcName;
	
	private boolean isAvailable;

}
