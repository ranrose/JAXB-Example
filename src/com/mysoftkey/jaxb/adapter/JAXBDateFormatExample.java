
package com.mysoftkey.jaxb.adapter;

import java.io.File;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * This example class is used to formate XML representation date to java
 * representation date. and vice-versa using JAXB.
 * 
 *
 * @author ranjeet.jha
 */
public class JAXBDateFormatExample {

 public static void main(String args[]) {

  try {
   Date dob = new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime();

   Person person = new Person("Ranjeet Jha", dob);

   // Marshaling Employee object to XML using JAXB
   JAXBContext ctx = null;
   StringWriter writer = new StringWriter();

   ctx = JAXBContext.newInstance(Person.class);
   Marshaller m = ctx.createMarshaller();
   /*
    * System.out.println("Person object as XML"); System.out.println(writer);
    */
   m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

   // Write to System.out
   m.marshal(person, System.out);

   // Write to File, under docs which is inside the project
   m.marshal(person, new File("./docs/person.xml"));

  } catch (JAXBException ex) {
   ex.printStackTrace();
  }
 }

}
