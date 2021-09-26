package first.mvc.project.models;

import first.mvc.project.models.enums.OrdersStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders_statuses")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class OrdersStatuses implements Serializable {
    @Id
    @Column(name = "order_status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('pending', 'processed', 'closed')")
    private OrdersStatus status;

    String description;
}
// how to select by ENUM example
//    List<User> users =
//            session.createCriteria(User.class)
//                    .add(Restrictions.eq("gender", Gender.male))
//                    .list();


