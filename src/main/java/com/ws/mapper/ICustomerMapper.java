package com.ws.mapper;

import com.ws.model.Customer;
import com.ws.model.dto.CustomerDto;
import com.ws.model.dto.CustomerRequest;
import com.ws.model.dto.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi" , uses = IProductMapper.class)
public interface ICustomerMapper {

    Customer toEntity(CustomerDto customerDto);
    Customer toEntity(CustomerRequest customerDto);
    CustomerDto toDto(CustomerRequest customerDto);
    CustomerDto toDto(Customer customer);

   // @Mapping(target = "product" , expression = "java(customer.getProduct().getName())")
   // @Mapping(target = "price" , expression = "java(customer.getProduct().getPrice())")

    @Mapping(target = "product" , source = "customer.product.name")
    @Mapping(target = "price" , source = "customer.product.price")
    CustomerResponse toResponse(Customer customer);
}
