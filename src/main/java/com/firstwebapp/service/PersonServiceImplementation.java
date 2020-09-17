package com.firstwebapp.service;

import java.util.List;

import com.firstwebapp.model.Person;
import com.firstwebapp.repositories.PersonRepository;
import com.firstwebapp.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplementation implements PersonService{
    @Autowired PersonRepository perRepository;

    public Person save(Person per) {
        return perRepository.save(per);
    }
    public Person update(Person per){
        return perRepository.save(per);
    }
    public List<Person> getAllPerson() {
        return perRepository.findAll();
    }
    public void deletePerson( String id) {
        perRepository.deleteById(id);
    }
   /* public Person getPerson(String id){
        return  perRepository.findById(id);
    }*/
}