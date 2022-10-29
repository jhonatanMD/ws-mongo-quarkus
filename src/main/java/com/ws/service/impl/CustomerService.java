package com.ws.service.impl;

import com.ws.mapper.ICustomerMapper;
import com.ws.model.Customer;
import com.ws.model.dto.CustomerDto;
import com.ws.model.dto.CustomerRequest;
import com.ws.model.dto.CustomerResponse;
import com.ws.repository.CustomerRepository;
import com.ws.service.ICustomersService;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService implements ICustomersService {

    private final CustomerRepository customerRepository;
    private final ICustomerMapper mapper;

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.listAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public CustomerDto save(CustomerRequest customer) {
        customerRepository.persist(mapper.toEntity(customer));
        return  mapper.toDto(customer);
    }

    @Override
    public CustomerResponse findById(String id) {
        return mapper.toResponse(customerRepository.findById(new ObjectId(id)));
    }

}
