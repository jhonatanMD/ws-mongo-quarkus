package com.ws.repository;

import com.ws.model.Customer;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheMongoRepository<Customer> {


    public Customer findByName(String name){
        return find("name",name).firstResult();
    }

}
