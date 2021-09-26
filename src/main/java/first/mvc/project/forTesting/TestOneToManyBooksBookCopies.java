package first.mvc.project.forTesting;

import first.mvc.project.dao.implementations.BooksCopiesDaoImp;
import first.mvc.project.models.BooksCopies;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestOneToManyBooksBookCopies {
    static ApplicationContext context =
            new AnnotationConfigApplicationContext(String.class);

    public static void main(String[] args) {
        BooksCopiesDaoImp booksCopiesDaoImp
                = context.getBean("booksCopiesDaoImp", BooksCopiesDaoImp.class);
//        booksCopiesDaoImp.readById()
    }
}
