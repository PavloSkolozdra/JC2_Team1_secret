package first.mvc.project.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Orders implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**Attention. Has dependency to User.id**/
    private Long user_id;

    private Long book_id;

    private LocalDate order_date;

    private LocalDate processed_date;

    @Future
    private LocalDate due_date;

    private LocalDate return_date;

    private Long book_copy_id;

    /**Attention. Has dependency to OrdersStatuses.id**/
    private Long order_status_id;

    @Size(max = 255, message = "Description should be 255 characters max!")
    private String description;

    @ManyToOne
    @JoinColumn(name="book_copy_id", insertable = false, updatable = false)
    private BooksCopies booksCopies;

    @ManyToOne
    @JoinColumn(name="order_status_id", insertable = false, updatable = false)
    private OrdersStatuses ordersStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users users;

}
