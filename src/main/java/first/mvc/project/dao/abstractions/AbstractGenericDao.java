package first.mvc.project.dao.abstractions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;

//@Transactional
public abstract class AbstractGenericDao<T extends Serializable> {

    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setClazz(Class<T> clazzToSet){
        clazz = clazzToSet;
    }

    @Transactional (readOnly = true)
    public T readById(Long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Transactional(readOnly = true)
    public List<T> readAll() {
        return getCurrentSession().createQuery("FROM " + clazz.getName()).list();
    }

    public void create(T entity) {
        getCurrentSession().save( entity );
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge( entity );
    }

    public void delete(T entity){
        getCurrentSession().delete(entity);
    }

    public void deleteById(Long id){
        final T entity = readById(id);
        delete(entity);
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
