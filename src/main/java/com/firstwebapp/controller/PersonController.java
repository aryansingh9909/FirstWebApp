package com.firstwebapp.controller;

import java.util.Date;

import com.firstwebapp.model.Person;
import com.firstwebapp.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@RequestMapping("/api")
public class PersonController {

  @Autowired
  PersonService perService;

  //Create Operation
  @RequestMapping("/create")
  public String create(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String gender, @RequestParam Date dob) {
      Person p = perService.findByFirstnameContaining(firstname);
        return p.toString();
  }

   @RequestMapping("/get")
  public Person getPerson(@RequestParam String firstname){
      return perService.findByFirstnameContaining(firstname);
  }
  
  @RequestMapping("/getAll")
    public String update(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String gender, @RequestParam Date dob){
     Person p = perService.update(firstname, lastname, gender,dob);
        return p.toString();
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam String firstname) {
         perService.delete(firstname);
         return "deleted"+ firstname;
    }
    @RequestMapping("/deleteAll") 
        public String deleteAll(){
            perService.deleteAll();
            return "deleted all records";
        }
}