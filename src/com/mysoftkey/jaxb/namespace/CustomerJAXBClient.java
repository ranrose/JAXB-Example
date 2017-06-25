/**
 * 
 */
package com.mysoftkey.jaxb.namespace;

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
public class CustomerJAXBClient {

	public static final String CUSTOMER_FILE = "./docs/customer.xml";
	
	public static void main(String[] args)  {

		try {
	  marshalCustomer();
			//getCustomerByreadingXML();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void marshalCustomer() {

		try {
			// create customer object and populate values.
			Customer customer = new Customer(1, "Anushka", 12);
			
			// add address into customer in addresses property
			customer.addAddrss(new Address("Street no1 ", "New Delhi", "Delhi"));
			customer.addAddrss(new Address("Street no 2 ", "New Delhi", "Delhi"));
			
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
