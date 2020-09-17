package com.firstwebapp.repositories;

import java.util.List;

import com.firstwebapp.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;

//here, Person is entity and String is datatype of id  (i.e. String see in Person.java)
public interface PersonRepository extends MongoRepository<Person, String> {
  List<Person> findByFirstnameContaining(String firstname);
 
  
}