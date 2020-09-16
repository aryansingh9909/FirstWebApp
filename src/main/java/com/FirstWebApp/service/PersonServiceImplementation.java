package com.FirstWebApp.service;

import java.util.List;
import com.app.springbootrestwithmongo.entity.Person;
import com.FirstWebApp.model.Person;
import com.FirstWebApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PersonServiceImplementation implements PersonService{
    @Autowired
    private PersonRepository perRepository;

    public Person save(Person per) {
        return perRepository.save(per);
    }
    public Person update(Person per){
        return perRepository.save(per);
    }
    public List<Person> getAllPerson() {
        return perRepository.findAll(per);
    }
    public void deletePerson( String id) {
        perRepository.delete(id);
    }
    public Person getPerson(String id){
        return  perRepository.findOne(id);
    }
}