package mfh.learn.hib.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mfh.learn.hib.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mfh.learn.hib.repository.CustomerRepository;

import java.util.List;

@Service("defaultCustomerService")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll(true);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findByID(String customerID) {
        return customerRepository.findOne(customerID);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    @Transactional
    public void delete(String id) {
        customerRepository.deleteById(id);
    }


}
