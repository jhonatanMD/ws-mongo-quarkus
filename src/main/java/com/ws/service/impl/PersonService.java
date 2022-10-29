package com.ws.service.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.ws.model.Person;
import com.ws.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonService implements IPersonService {

    private final MongoClient client;

    @ConfigProperty(name = "var.db")
    private String database;

    @ConfigProperty(name = "var.c1")
    private String personCollection;


    @Override
    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try{

            while (cursor.hasNext()){
                Document document = cursor.next();
                Person person = new Person();
                person.setId(document.getLong("id"));
                person.setName(document.getString("name"));
                person.setAge(document.getString("age"));
                person.setBirthdate(document.getString("birthdate"));
                persons.add(person);
            }

        }finally {
            cursor.close();
        }

        return persons;
    }

    @Override
    public Person save(Person person) {

        Document document = new Document()
                .append("id",person.getId())
                .append("name",person.getName())
                .append("age",person.getAge())
                .append("birthdate",person.getBirthdate());

        getCollection().insertOne(document);

        return person;
    }


    private MongoCollection getCollection(){
        return client.getDatabase(database).getCollection(personCollection);
    }

}
