package com.ranjeet.jaxb.person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Ranjeet.Jha
 *
 */
public class PersonAppClient {

	 private static final String PERSON_XML = "./docs/person.xml";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person = populatePerson();
		
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			
			Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		    // Write to System.out
		    m.marshal(person, System.out);

		    // Write to File
		    m.marshal(person, new File(PERSON_XML));

		   
		    // load object tree from our xml file, that created before
		    System.out.println("Output from our XML File: ");
		    Unmarshaller umUnmarshaller = context.createUnmarshaller();
			Person unPersonObj = (Person) umUnmarshaller.unmarshal(new FileReader(PERSON_XML));
			System.out.println("id: " + unPersonObj.getId() + " , name: " + unPersonObj.getName() + " , location: "  + unPersonObj.getLocation());
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	public static Person populatePerson() {
		Person p = new Person();
		p.setId("1");
		p.setName("ranjeet");
		p.setLocation("New Delhi");
		return p;
	}

}
