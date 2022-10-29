package com.ws.service.impl;

import com.ws.model.Customer;
import com.ws.repository.CustomerRepository;
import com.ws.service.ICustomersService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService implements ICustomersService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.listAll();
    }

    @Override
    public Customer save(Customer customer) {
        customerRepository.persist(customer);
        return customer;
    }
}
