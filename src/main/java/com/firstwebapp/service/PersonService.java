package com.firstwebapp.service;

import java.util.Date;
import java.util.List;

import com.firstwebapp.model.Person;
public interface PersonService {
    Person create(String firstname, String lastname, String gender, Date dob);
    List<Person> getAllPerson();
    Person findByFirstnameContaining(String firstname);
    Person update(String firstname, String lastname, String gender, Date dob);
    void deleteAll();
    void delete( String firstname);
}
