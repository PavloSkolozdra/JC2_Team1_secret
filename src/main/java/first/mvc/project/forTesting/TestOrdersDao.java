package first.mvc.project.forTesting;

import first.mvc.project.config.HibernateConf;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.OrdersDaoImp;
import first.mvc.project.models.Orders;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.time.LocalDate;


public class TestOrdersDao {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConf.class);
        System.out.println("Application context created");

        OrdersDaoImp ordersDaoImp =
                context.getBean("ordersDaoImp", OrdersDaoImp.class);

        Orders orders = new Orders();
        orders.setUser_id(2L); // DANGER, has foreign key!
        orders.setBook_id(4L);
        orders.setOrder_date(LocalDate.parse( "2088-09-20" ));
        orders.setProcessed_date(LocalDate.parse( "2099-10-20" ));
        orders.setDue_date(LocalDate.parse( "2122-11-20" ));
        orders.setReturn_date(LocalDate.parse( "2200-12-20" ));
        orders.setBook_copy_id(1L); // DANGER, has foreign key!
        orders.setOrder_status_id(2L);
        ordersDaoImp.create(orders);
//        System.out.println(ordersDaoImp.readById(1L));
    }
}
