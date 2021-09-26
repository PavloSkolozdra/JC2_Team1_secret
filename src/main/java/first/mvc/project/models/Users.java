package first.mvc.project.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Users implements Serializable {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "username cannot be empty")
    @Size(min=3, max=16, message = "username should be from 3 to 16 characters long!")
    private String username;

    @Email(message = "please enter correct email")
    private String email;

    @NotBlank
    @Size(min=8, max=16, message = "password should be from 8 to 16 characters long!")
    private String password;

    @NotBlank(message = "first name cannot be empty")
    @Size(min=3, max=32, message = "first name should be from 3 to 32 characters long!")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    @Size(min=3, max=32, message = "last name should be from 3 to 32 characters long!")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Min(value = 16, message = "Age cannot be less than 16")
    @Max(value = 150, message = "Age should not be greater than 150")
    int age;

    @Column(name = "users_role_id")
    Long userRoleId;

    @Size(max = 255, message = "Description should be 255 characters max!")
    String description;

    @ManyToOne
    @JoinColumn(name = "users_role_id", insertable = false, updatable = false)
    private UserRoles userRole;
}
