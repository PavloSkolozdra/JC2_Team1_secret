package first.mvc.project.dao.implementations;

import first.mvc.project.dao.abstractions.AbstractGenericDao;
import first.mvc.project.dao.abstractions.IordersDao;
import first.mvc.project.models.OrdersStatuses;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersStatusesDaoImp extends AbstractGenericDao implements IordersDao {
    public OrdersStatusesDaoImp() {
        setClazz(OrdersStatuses.class);
    }
}
