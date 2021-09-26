package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IordersDao;
import first.mvc.project.models.UserRoles;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRolesDaoImp extends AbstractGenericDao implements IordersDao {
    public UsersRolesDaoImp() {
        setClazz(UserRoles.class);
    }
}
