package repository;

import mfh.spring.api.model.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DefaultCustomerRepository extends CustomerRepository {

    public List<Customer> findAllWithPagination(int pageNumber) {
        return findAllWithPagination(false, pageNumber);
    }

    public List<Customer> findAllWithPagination(boolean isCacheable, int pageNumber) {

        try (Session session = getOpenSession();) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            if (pageNumber <= 0) {
                pageNumber = 1;
            }

            int startIndex = (pageNumber - 1) * pageSize;
            if (startIndex < 0) {
                startIndex = 0;
            }

            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(getReferenceClass());
            Root root = criteriaQuery.from(getReferenceClass());
            Query<Customer> query = session.createQuery(criteriaQuery);
            query.setFirstResult(startIndex);
            query.setMaxResults(pageSize);
            return query.list();
        }
    }
}