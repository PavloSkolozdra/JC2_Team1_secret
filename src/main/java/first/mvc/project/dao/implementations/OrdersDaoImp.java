package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IordersDao;
import first.mvc.project.models.Orders;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImp extends AbstractGenericDao implements IordersDao {
    public OrdersDaoImp() {setClazz(Orders.class);
    }
}
