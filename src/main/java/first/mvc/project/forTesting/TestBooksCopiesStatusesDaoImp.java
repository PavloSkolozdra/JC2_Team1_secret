package first.mvc.project.forTesting;

import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.BooksCopiesStatusesDaoImp;
import first.mvc.project.models.enums.BookCopiesStatus;
import first.mvc.project.models.BooksCopiesStatuses;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBooksCopiesStatusesDaoImp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BooksCopiesStatusesDaoImp booksCopiesStatusesDaoImp =
                context.getBean("booksCopiesStatusesDaoImp", BooksCopiesStatusesDaoImp.class);
        BooksCopiesStatuses b = new BooksCopiesStatuses();
        b.setStatus(BookCopiesStatus.LOST);
        System.out.println(booksCopiesStatusesDaoImp.readById(1L));
//        booksCopiesStatusesDaoImp.create(b);

    }
}
