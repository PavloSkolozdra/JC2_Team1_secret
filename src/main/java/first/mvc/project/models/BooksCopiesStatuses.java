package first.mvc.project.models;

import first.mvc.project.models.enums.BookCopiesStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "books_copies_statuses")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class BooksCopiesStatuses implements Serializable {
    @Id
    @Column(name = "status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition="enum('ISSUED','AVAILABLE','DELETED','LOST')")
    private BookCopiesStatus status;

    @Column(name = "description")
    @Size(max = 255, message = "Description should be 255 characters max!")
    String description;

//    @OneToMany
//    @JoinColumn(name = "")
//    private List<BooksCopies> booksCopiesList;
}
// how to select by ENUM example
//    List<User> users =
//            session.createCriteria(User.class)
//                    .add(Restrictions.eq("gender", Gender.male))
//                    .list();


