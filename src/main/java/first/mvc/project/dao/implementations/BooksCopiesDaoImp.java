package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IbooksCopiesDao;
import first.mvc.project.models.BooksCopies;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BooksCopiesDaoImp extends AbstractGenericDao<BooksCopies> implements IbooksCopiesDao {
    public BooksCopiesDaoImp() {
        setClazz(BooksCopies.class);
    }

    public BooksCopies findAvailableCopyByBookId(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT bc FROM BooksCopies bc WHERE bc.status_id=2 AND bc.book_id = :value");
        query.setParameter("value", id);
        BooksCopies result = null;
        try {
            result = (BooksCopies) query.setMaxResults(1).getResultList().get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There are no available books right now.");
        }
        return result;
    }

}
