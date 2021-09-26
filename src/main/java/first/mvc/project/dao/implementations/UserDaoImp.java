package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IuserDao;
import first.mvc.project.models.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp extends AbstractGenericDao implements IuserDao {
    public UserDaoImp() {
        setClazz(Users.class);
    }
}
