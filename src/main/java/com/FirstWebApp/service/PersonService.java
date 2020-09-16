package com.FirstWebApp.service;

import java.util.List;
import com.app.springbootrestwithmongo.entity.Person;
public interface PersonService {
    Person save(Person per);
    Person update(Person per);
    List<Person> getAllPerson();
    void deletePerson( String id);
    Person getPerson(String id);
}
