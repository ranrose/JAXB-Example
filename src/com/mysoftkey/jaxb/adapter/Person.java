package com.mysoftkey.jaxb.adapter;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * This is POJO class for Person object.
 * 
 * @author ranjeet.jha
 *
 */
@XmlRootElement(name="person") 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Person { 
 
 @XmlElement(name="name") 
 private String name; 
 
 @XmlElement(name="dateOfBirth") 
 @XmlJavaTypeAdapter(MyDateAdapter.class)
 private Date dateOfBirth; 
 
 // no-arg default constructor for JAXB 
 public Person(){} 
 
 public Person(String name, Date dateOfBirth) { 
  this.name = name; 
  this.dateOfBirth = dateOfBirth; 
  } 

 public Date getDateOfBirth() { 
  return dateOfBirth; 
  } 
 public void setDateOfBirth(Date dateOfBirth) {
  this.dateOfBirth = dateOfBirth; 
  }
 
 public String getName() { return name; } 
 
 public void setName(String name) {
  this.name = name; 
  } 
 
 @Override public String toString() { 
  return "{name : " + name + ", dateOfBirth : " + dateOfBirth + "}"; 
  } 
 }
