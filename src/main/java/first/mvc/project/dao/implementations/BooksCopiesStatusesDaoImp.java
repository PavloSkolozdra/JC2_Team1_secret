package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IbooksCopiesStatuses;
import first.mvc.project.models.BooksCopiesStatuses;
import org.springframework.stereotype.Repository;

@Repository
public class BooksCopiesStatusesDaoImp extends AbstractGenericDao implements IbooksCopiesStatuses {
    public BooksCopiesStatusesDaoImp() {setClazz(BooksCopiesStatuses.class);
    }
}
