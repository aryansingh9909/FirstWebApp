package com.FirstWebApp.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.FirstWebApp.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
  List<Person> findByfirstnameContaining(String title);
  
}