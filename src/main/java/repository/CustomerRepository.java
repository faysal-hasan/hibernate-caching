package repository;

import model.Customer;

public abstract class CustomerRepository extends AbstractHibernateDAO<Customer> {
    public CustomerRepository() {
        setClass(getReferenceClass());
    }

    public Class getReferenceClass() {
        return Customer.class;
    }

}