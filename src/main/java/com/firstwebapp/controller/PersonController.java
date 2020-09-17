package com.firstwebapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.firstwebapp.model.Person;
import com.firstwebapp.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {

  @Autowired
  PersonRepository perRepository;

  //Create Operation
  @PostMapping("/collections")
    public ResponseEntity<Person> createPerson(@RequestBody Person per) {
        try {
            Person _pp = perRepository.save(new Person(per.getFirstname(), per.getLastname(), per.getGender(), per.getDob()));
            return new ResponseEntity<>(_pp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

//Retrieve Operations
//returns List of Person, if there is firstname parameter, it returns a List in that each Person contains the firstname
    @GetMapping("/collections")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String firstname) {
        try {
            List<Person> per = new ArrayList<Person>();
            if (firstname == null)
                perRepository.findAll().forEach(per::add);
            else
                perRepository.findByFirstnameContaining(firstname).forEach(per::add);
            if (per.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(per, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //returns Persons by given id
    @GetMapping("/collections/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") String id) {
        Optional<Person> perData = perRepository.findById(id);
        if (perData.isPresent()) {
            return new ResponseEntity<>(perData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//update operation 
    @PutMapping("/collections/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") String id, @RequestBody Person per) {
        Optional<Person> perData = perRepository.findById(id);
        if (perData.isPresent()) {
            Person _pp = perData.get();
            _pp.setFirstname(per.getFirstname());
            _pp.setLastname(per.getLastname());
            _pp.setGender(per.getGender());
            _pp.setDob(per.getDob());
            return new ResponseEntity<>(perRepository.save(_pp), HttpStatus.OK);
        } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete operation
    //delete a Person document with given id
    @DeleteMapping("/collections/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") String id) {
        try {
            perRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //remove all documents in Persons collection
    @DeleteMapping("/collections")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        try {
            perRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}