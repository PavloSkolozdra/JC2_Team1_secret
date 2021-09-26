package first.mvc.project.models;

import first.mvc.project.models.enums.UsersRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users_role")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class UserRoles implements Serializable {
    @Id
    @Column(name = "users_role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('manager', 'reader')")
    private UsersRole role;

    @Size(max = 255, message = "Description should be 255 characters max!")
    String description;
}
// how to select by ENUM example
//    List<User> users =
//            session.createCriteria(User.class)
//                    .add(Restrictions.eq("gender", Gender.male))
//                    .list();


