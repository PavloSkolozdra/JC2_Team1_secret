package first.mvc.project.models;

import first.mvc.project.models.enums.AuthorRole;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books_authors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class BooksAuthors implements Serializable {
    @Id
    @Column(name = "book_id", nullable = false)
    private Long book_id;

    private Long author_id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('AUTHOR', 'CO_AUTHOR')")
    private AuthorRole author_role;
}
