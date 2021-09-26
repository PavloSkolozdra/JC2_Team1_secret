package first.mvc.project.forTesting;

import first.mvc.project.config.HibernateConf;
import first.mvc.project.config.SpringConfig;
import first.mvc.project.dao.implementations.UserDaoImp;
import first.mvc.project.models.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUsersDao {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConf.class);
        System.out.println("Application context created");

        UserDaoImp userDaoImp =
                context.getBean("userDaoImp", UserDaoImp.class);

        Users users = new Users();
        users.setUsername("DaynerisTargarian");
        users.setEmail("dayn@gmail.com");
        users.setUserRoleId(2L);
        userDaoImp.create(users);
    }
}
