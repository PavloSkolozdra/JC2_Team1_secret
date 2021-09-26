package first.mvc.project.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "books_copies")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class BooksCopies implements Serializable {
    @Id
    @Column(name = "book_copy_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PositiveOrZero
    private Long book_id;

    @NotNull
    @Min(value = 1, message = "Status should be from 1 to 4.")
    @Max(value = 4, message = "Status should be from 1 to 4.")
    private Long status_id;

    @Size(max = 255, message = "Description should be 255 characters max!")
    private String description;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Books books;

    @ManyToOne
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private BooksCopiesStatuses booksCopiesStatuses;

}
