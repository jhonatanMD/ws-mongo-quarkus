package com.ws.service;

import com.ws.model.dto.CustomerDto;
import com.ws.model.dto.CustomerRequest;
import com.ws.model.dto.CustomerResponse;

import java.util.List;

public interface ICustomersService {
    List<CustomerDto> findAll();
    CustomerDto save(CustomerRequest customer);
    CustomerResponse findById(String id);
}
