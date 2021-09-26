package first.mvc.project.forTesting;

import first.mvc.project.config.HibernateConf;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.OrdersStatusesDaoImp;
import first.mvc.project.models.enums.OrdersStatus;
import first.mvc.project.models.OrdersStatuses;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestOrdersStatusesDao {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConf.class);
        System.out.println("Application context created");

        OrdersStatusesDaoImp ordersDaoImp =
                context.getBean("ordersStatusesDaoImp", OrdersStatusesDaoImp.class);

        OrdersStatuses oSt = new OrdersStatuses();
        oSt.setStatus(OrdersStatus.pending);
        ordersDaoImp.create(oSt);

    }
}
