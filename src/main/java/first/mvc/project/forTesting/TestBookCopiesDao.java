package first.mvc.project.forTesting;

import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.BooksCopiesDaoImp;
import first.mvc.project.models.BooksCopies;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBookCopiesDao {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BooksCopiesDaoImp booksCopiesDaoImp =
                context.getBean("booksCopiesDaoImp", BooksCopiesDaoImp.class);
        System.out.println(booksCopiesDaoImp.readById(1L).getBooks());
        BooksCopies bc = new BooksCopies();
        bc.setId(43L);
        bc.setBook_id(9L);
        bc.setStatus_id(4L);
        bc.setDescription("test");
        booksCopiesDaoImp.create(bc);
    }

}
