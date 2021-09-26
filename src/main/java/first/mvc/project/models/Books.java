package first.mvc.project.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Books implements Serializable {
    @Id
    @Column(name = "book_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 2, max = 255, message = "Title should be from 2 to 255 characters long!")
    private String title;

    @NotNull(message = "Year cannot be null")
    @Min(value = 1700, message = "Year cannot be less than 1700")
    @Max(value = 2500, message = "Year should not be greater than 2500")
    @Size(min = 4, max = 4, message = "Year should be 4 digits long!")
    private int year;

    @Size(max = 255, message = "Description should be 255 characters max!")
    private String description;

    @Transient
    private Authors mainAuthor;

    @Transient
    private List<Authors> coAuthors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ToString.Exclude
    private List<Authors> authors = new ArrayList<>();
}