package mfh.learn.hib.repository;

import mfh.learn.hib.model.Customer;

public abstract class CustomerRepository extends AbstractHibernateDAO<Customer> {
    public CustomerRepository() {
        setClass(getReferenceClass());
    }

    public Class getReferenceClass() {
        return Customer.class;
    }

}