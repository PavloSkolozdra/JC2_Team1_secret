package first.mvc.project.forTesting;

import first.mvc.project.config.HibernateConf;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.BookDaoImp;
import first.mvc.project.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Transactional
public class TestUserService {
    static ApplicationContext context =
            new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConf.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory =
                context.getBean("sessionFactory", SessionFactory.class);
        UserService userService = context.getBean("userService", UserService.class);
        BookDaoImp bookDaoImp = context.getBean("bookDaoImp", BookDaoImp.class);
        Transaction tx =sessionFactory.getCurrentSession().beginTransaction();

        System.out.println(userService.getMostPopInPeriod(LocalDate.parse("2021-05-02"), LocalDate.parse("2021-06-02")));

        tx.commit();
    }
}
