package com.firstwebappusingrestapi.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collections")
public class Person {
  @Id
  private String id;

  private String firstname;
  private String lastname;
  private String gender;
  private Date dob;
  
  public Person(){

  }
    
 public Person(String firstname, String lastname, String gender, Date dob) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.gender = gender;
      this.dob = dob;
  }

  public String getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

 public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", dob=" + dob + "]";
  }

}