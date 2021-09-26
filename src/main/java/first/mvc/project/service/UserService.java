package first.mvc.project.service;

import first.mvc.project.dao.implementations.BookDaoImp;
import first.mvc.project.dao.implementations.BooksCopiesDaoImp;
import first.mvc.project.models.Books;
import first.mvc.project.models.BooksCopies;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private BookDaoImp bookDaoImp;
    @Autowired
    private BooksCopiesDaoImp booksCopiesDaoImp;
    @Autowired
    private SessionFactory sessionFactory;

    public List<Books> getAllBooksInfo() {
        List<Books> result;
        result = bookDaoImp.readAll();
        result.forEach(b -> b.setCoAuthors(bookDaoImp.getCoAuthorsByBookId(b.getId())));
        result.forEach(books -> books.setMainAuthor(bookDaoImp.getMainAuthorByBookId(books.getId())));
        return result;
    }

    public boolean checkIfAvailableByTitle(String title) {
        Books book = bookDaoImp.getBookByTitle(title);
        if (book == null) {
            return false;
        } else {
            BooksCopies bc = booksCopiesDaoImp.findAvailableCopyByBookId(book.getId());
            if (bc == null) {
                System.err.println("Book is not available right now.");
                return false;
            }
        }
        return true;
    }

    public List<Books> findBooksByAuthor(String author) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Books b " +
                        "JOIN b.authors aut " +
                        "WHERE :value LIKE concat('%', aut.first_name, '%') " +
                        "AND :value LIKE concat('%', aut.last_name, '%')");
        query.setParameter("value", author);
        List<Books> result = query.list();
        if (result.size() == 0) {
            System.out.println("There is no books of that author.");
        }
        return result;
    }

    public Books getMostPopInPeriod(LocalDate dateFrom, LocalDate dateTo){
        Query queryString = sessionFactory.getCurrentSession()
                .createQuery("SELECT ord.book_id " +
                        "FROM Orders ord WHERE ord.order_date " +
                        "BETWEEN :dateFrom AND :dateTo GROUP BY ord.book_id " +
                        "ORDER BY COUNT(ord.book_id) DESC" );
        queryString.setParameter("dateFrom", dateFrom);
        queryString.setParameter("dateTo", dateTo);
        try {
            return bookDaoImp.readById((Long)queryString.list().get(0));
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no such book!");
        }
        return null;
    }

    public Books getMostUnPopInPeriod(LocalDate dateFrom, LocalDate dateTo){
        Query queryString = sessionFactory.getCurrentSession()
                .createQuery("SELECT ord.book_id FROM Orders ord " +
                        "WHERE ord.order_date BETWEEN :dateFrom AND :dateTo " +
                        "GROUP BY ord.book_id ORDER BY COUNT(ord.book_id)" );
        queryString.setParameter("dateFrom", dateFrom);
        queryString.setParameter("dateTo", dateTo);
        try {
            return bookDaoImp.readById((Long)queryString.list().get(0));
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no such book!");
        }
       return null;
    }

}
