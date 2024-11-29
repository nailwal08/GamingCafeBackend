@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "pc_id", nullable = false)
	    private PersonalComputer pc;

	    @Column(nullable = false, unique = true)
		@NotBlank(message = "UserName cannot be blank")
	    private String userName;

	    private LocalDateTime startTime;

	    private LocalDateTime endTime;

	    private long duration; 

	    private double charges; 

	    private boolean isActive; 

	   
}
