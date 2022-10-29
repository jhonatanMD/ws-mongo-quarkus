package com.ws.service;

import com.ws.model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();
    Person save (Person person);
}
