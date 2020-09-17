package com.firstwebapp.repositories;

import com.firstwebapp.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//here, Person is entity and String is datatype of id  (i.e. String see in Person.java)
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
  Person findByFirstnameContaining(String firstname);
 
  
}