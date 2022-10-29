package com.ws.service;

import com.ws.model.Customer;

import java.util.List;

public interface ICustomersService {
    List<Customer> findAll();
    Customer save(Customer customer);
}
