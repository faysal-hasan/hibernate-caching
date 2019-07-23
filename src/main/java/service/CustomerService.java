package service;

import model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findByID(String id);

    void save(Customer customer);

    void update(Customer customer);

    void delete(String id);

}
