package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDAO<T extends Serializable> {
    public static final int pageSize = 1;
    private Class<T> clazz;
    @Autowired
    private SessionFactory sessionFactory;

    public void setClass(Class<T> classToSet) {
        clazz = classToSet;
    }

    public T findOne(String id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public List findAll() {
        return findAll(false);
    }

    public List findAll(boolean isCacheable) {
        Session currentSession = getCurrentSession();
        Query query = currentSession
                .createQuery("from " + clazz.getName());
        query.setCacheable(isCacheable);
        return query.list();
    }

    public void save(T entity) {
        getCurrentSession().save(entity);
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(String id) {
        final T entity = findOne(id);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected final Session getOpenSession() {
        return sessionFactory.openSession();
    }


    public int getTotalRowCount(Class clazz) {
        return getTotalRowCount(clazz, null);
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalRowCount(Class clazz, List<Predicate> predicateList) {
        try (Session session = getOpenSession();) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
            criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(clazz)));
            if (predicateList != null && !predicateList.isEmpty()) {
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
            }
            Long countResults = session.createQuery(criteriaQuery).uniqueResult();
//            int totalPageNumber = (int) (Math.ceil(countResults / pageSize));
            return countResults.intValue();
        }
    }
}