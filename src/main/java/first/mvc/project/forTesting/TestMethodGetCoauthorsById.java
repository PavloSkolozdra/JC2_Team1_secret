package first.mvc.project.forTesting;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.BookDaoImp;
import first.mvc.project.dao.implementations.BooksCopiesDaoImp;
import first.mvc.project.models.Books;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class TestMethodGetCoauthorsById {
    static ApplicationContext context =
            new AnnotationConfigApplicationContext(SpringConfig.class);
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                context.getBean("sessionFactory", SessionFactory.class);
        BookDaoImp bookDAO = context.getBean("bookDaoImp", BookDaoImp.class);
        BooksCopiesDaoImp booksCopiesDaoImp = context.getBean("booksCopiesDaoImp", BooksCopiesDaoImp.class);

        Transaction tx =sessionFactory.getCurrentSession().beginTransaction();

//        System.out.println(bookDAO.getBookByTitle("some first book"));
        System.out.println(booksCopiesDaoImp.findAvailableCopyByBookId(6L));

        tx.commit();
    }
}
