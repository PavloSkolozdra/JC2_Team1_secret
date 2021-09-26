package first.mvc.project.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Authors implements Serializable {

    @Id
    @Column(name = "author_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name cannot be empty")
    @Size(min = 2, max = 45, message = "First name should be from 2 to 45 characters long!")
    private String first_name;

    @NotNull(message = "Last name cannot be empty")
    @Size(min = 2, max = 45, message = "Last name should be from 2 to 45 characters long!")
    private String last_name;

    @Size(max = 255, message = "Description should be 255 characters max!")
    private String description;

    @ManyToMany(
            //cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "authors"
            //targetEntity = Book.class
    )
    @ToString.Exclude
    private List<Books> booksSet = new ArrayList<>();
}
