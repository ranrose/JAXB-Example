/**
 * 
 */
package com.dg.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ranjeet.jaxb.day1.Book;
import com.ranjeet.jaxb.day1.Bookstore;

/**
 * @author Ranjeet.Jha
 *
 */
public class CustomerJAXBClient {

	public static final String CUSTOMER_FILE = "./docs/customer.xml";
	
	public static void main(String[] args) throws FileNotFoundException {

		//marshalCustomer();
		try {
			getCustomerByreadingXML();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 */
	private static void marshalCustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Anushka");
		customer.setAge(5);

		try {

			File file = new File(CUSTOMER_FILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
			
			//Customer cust = getCustomerByreadingXML();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Customer getCustomerByreadingXML() throws JAXBException, FileNotFoundException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		
		// get variables from our xml file, created before
		System.out.println("Output from our XML File: ");
		Unmarshaller um = jaxbContext.createUnmarshaller();
		Customer cust = (Customer) um.unmarshal(new FileReader(CUSTOMER_FILE));
		System.out.println(cust.getName());
		return cust;
	}

}
