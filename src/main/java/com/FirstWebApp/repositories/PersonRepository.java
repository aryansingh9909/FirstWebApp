package com.FirstWebApp.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.FirstWebApp.model.Person;

//here, Person is entity and String is datatype of id  (i.e. String see in Person.java)
public interface PersonRepository extends MongoRepository<Person, String> {
  List<Person> findByFirstnameContaining(String title);
  
}