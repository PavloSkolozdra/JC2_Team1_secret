package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IauthorsDao;
import first.mvc.project.models.Authors;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorsDaoImp extends AbstractGenericDao<Authors> implements IauthorsDao {
    public AuthorsDaoImp() {
        setClazz(Authors.class);
    }
}
