package first.mvc.project.forTesting;

import first.mvc.project.config.HibernateConf;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.UsersRolesDaoImp;
import first.mvc.project.models.UserRoles;
import first.mvc.project.models.enums.UsersRole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUsersRolesDao {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConf.class);
        System.out.println("Application context created");

        UsersRolesDaoImp usersRolesDaoImp =
                context.getBean("usersRolesDaoImp", UsersRolesDaoImp.class);

        UserRoles role = new UserRoles();
        role.setRole(UsersRole.reader);
        role.setDescription("reader access only");
        usersRolesDaoImp.create(role);
    }
}
