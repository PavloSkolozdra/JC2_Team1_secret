package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IbookDao;
import first.mvc.project.models.Authors;
import first.mvc.project.models.Books;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDaoImp extends AbstractGenericDao<Books> implements IbookDao {

    @Autowired
    AuthorsDaoImp authorsDAO;

    public BookDaoImp() {
        setClazz(Books.class);
    }

    public List<Authors> getAllAuthorsByBookId(Long id){
        return readById(id).getAuthors();
    }

    public List<Authors> getCoAuthorsByBookId(Long id){
        String queryString = "SELECT DISTINCT author_id " +
                "FROM BooksAuthors " +
                "WHERE book_id= :value " +
                "AND author_role='CO_AUTHOR'";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("value", id);

        List<Long> bookCoAuthorsIds = query.list();

        List<Authors> coAuthors =
        bookCoAuthorsIds.stream()
                .map(x -> authorsDAO.readById(x))
                .collect(Collectors.toList());
        return coAuthors;
    }

    public Authors getMainAuthorByBookId(Long id){
        String queryString = "SELECT author_id " +
                "FROM BooksAuthors " +
                "WHERE book_id= :value " +
                "AND author_role='AUTHOR'";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("value", id);

        Long bookMainAuthorId = (Long)query.getSingleResult();

        return authorsDAO.readById(bookMainAuthorId);
    }

    public Books getBookByTitle(String title){
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Books b WHERE b.title= :value");
        query.setParameter("value", title);
        Books result = null;
        try{
            result = (Books) query.getSingleResult();
        }catch(NoResultException e){
            System.err.println("No such book in the library!");
        }
        return result;
    }

}
