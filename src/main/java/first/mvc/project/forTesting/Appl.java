package first.mvc.project.forTesting;

import first.mvc.project.config.HibernateConf;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.*;
import first.mvc.project.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@Service
public class Appl {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConf.class);
        System.out.println("Application context created");

        BookDaoImp bookDAO = context.getBean("bookDaoImp", BookDaoImp.class);

        //CREATE test
//        bookDAO.create(new Book(69, "New DAO69", 2069, "69"));
        //READ test
        //System.out.println(bookDAO.readById(13));
        //UPDATE test
        //bookDAO.update(new Book(24, "New DAO", 2044, ""));
        //DELETE test
        //bookDAO.delete(new Book(24, "New DAO", 2044, ""));
        //READ all test
//        bookDAO.readAll().stream().forEach(System.out::println);

        AuthorsDaoImp authorsDao = context.getBean("authorsDaoImp", AuthorsDaoImp.class);

//        authorsDao.create(new Authors(23L, "Pavlo", "Skolozdra", "des"));
//        System.out.println(authorsDao.readById(23L));
//        authorsDao.update(new Authors(23L, "New DAO", "Change", ""));
//        authorsDao.delete(new Authors(23L, "New DAO", "Change", ""));
//        authorsDao.deleteById(24L);
//        authorsDao.readAll().stream().forEach(System.out::println);

        BooksCopiesDaoImp booksCopiesDaoImp =
                context.getBean("booksCopiesDaoImp", BooksCopiesDaoImp.class);


//        booksCopiesDaoImp.create(new BooksCopies(43L,1L,1L, "my"));
//        System.out.println(booksCopiesDaoImp.readById(43L));
//        booksCopiesDaoImp.update(new BooksCopies(43L, 2L, 2L, "2"));
//        booksCopiesDaoImp.delete(new BooksCopies(44L, 1L, 1L, "my"));
//        booksCopiesDaoImp.deleteById(43L);
//        booksCopiesDaoImp.readAll().stream().forEach(System.out::println);

//        ONE TO MANY TESTING



        //MANY TO MANY TESTING
//        Book book = new Book();
//        book.setTitle("stener");
//        bookDAO.create(book);
//
//        Authors author = new Authors();
//        author.setFirst_name("sebtt");
//        author.setLast_name("rtnre");
//        authorsDao.create(author);

//        System.out.println(bookDAO.getAuthorsByBookId(1L));

        BooksAuthorsDaoImp booksAuthorsDaoImp =
                context.getBean("booksAuthorsDaoImp", BooksAuthorsDaoImp.class);
//        booksAuthorsDaoImp.create(new BooksAuthors(2L,4L, AuthorRole.CO_AUTHOR));
//        booksAuthorsDaoImp.create(new BooksAuthors(2L,2L, AuthorRole.AUTHOR));

//        BooksCopies bc = new BooksCopies();
//        bc.setBook_id(2L);
//        bc.setDescription("des");
//        bc.setStatus(4L);
//        booksCopiesDaoImp.create(bc);


//        Set bookSet = bookDAO.getAuthors(1L);
//        Set authorsSet = book.getAuthors(8L);
//        System.out.println();
//        authorsSet.stream().forEach(System.out::println);

//        Authors testAutor = authorsDao.readById(4L);
//        System.out.println(testAutor.getBookSet());

    }
}
