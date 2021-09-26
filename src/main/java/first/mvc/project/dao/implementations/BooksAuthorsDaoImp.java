package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IbooksAuthorsDao;
import first.mvc.project.models.BooksAuthors;
import org.springframework.stereotype.Repository;

@Repository
public class BooksAuthorsDaoImp extends AbstractGenericDao implements IbooksAuthorsDao {
    public BooksAuthorsDaoImp() { setClazz(BooksAuthors.class);
    }
}
