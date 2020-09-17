package com.firstwebapp.service;

import java.sql.Date;
import java.util.List;

import com.firstwebapp.model.Person;
import com.firstwebapp.repositories.PersonRepository;
import com.firstwebapp.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplementation implements PersonService{
    @Autowired PersonRepository perRepository;

    //create operation
     @Override
    public Person create(String firstname, String lastname, String gender, Date dob) {
        return perRepository.save(new Person(firstname,lastname,gender,dob));
    }

    //retrieve operation
     @Override
    public List<Person> getAllPerson() {
        return perRepository.findAll();
    }
     @Override
    public Person findByFirstnameContaining(String firstname){
        return perRepository.findByFirstnameContaining(firstname);
    }
    //update operation
     @Override
    public Person update(String firstname, String lastname, String gender, Date dob){
        Person p = perRepository.findByFirstnameContaining(firstname);
        p.setLastname(lastname);
        p.setGender(gender);
        p.setDob(dob);
        return perRepository.save(p);
    }
    @Override
   //delete operation
    public void deleteAll(){
       perRepository.deleteAll();
    }
     @Override
    public void delete( String firstname) {
         Person p = perRepository.findByFirstnameContaining(firstname);
        perRepository.delete(p);
    }
  
}