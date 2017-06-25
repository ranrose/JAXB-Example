/**
 * 
 */
package com.mysoftkey.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This is simple example :
 * 
 * <ul>
 * <li>to create from java object to XML</li>
 * <li>to create form XML to java object</li>
 * </ul>
 * 
 * @author Ranjeet.Jha
 *
 */
public class CustomerJAXBClient {

	// doc is a folder under the project, if not then create "doc" folder
	public static final String CUSTOMER_FILE = "./docs/customer.xml";

	public static void main(String[] args) throws FileNotFoundException {

		try {
			// convert java object to XML
			marshalCustomer();

			// call method to convert from xml to java object
			Customer customer = getCustomerFromXML();
			System.out.println("id: " + customer.getId() + ", name: " +
			customer.getName() + " , age: " + customer.getAge() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to marshal customer object.
	 */
	private static void marshalCustomer() {

		try {

			// create custome object and populate values to writ into xml
			Customer customer = new Customer();
			customer.setId(1);
			customer.setName("Anushka");
			customer.setAge(5);

			File file = new File(CUSTOMER_FILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// to print pretty output on console.
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			System.err.println("exception occured while converting java object to xml using JAXB , msg: " + e.getMessage());
		}
	}

	/**
	 * This method is used to convert from XML to java object.
	 * 
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	private static Customer getCustomerFromXML() {
		Customer cust = null;
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			// get variables from our xml file, created before
			System.out.println("Output from our XML File: ");
			Unmarshaller um = jaxbContext.createUnmarshaller();
			cust = (Customer) um.unmarshal(new FileReader(CUSTOMER_FILE));
		} catch (Exception e) {
			System.err
					.println("exception occured while converting from xml to java object using JAXB , msg: " + e.getMessage());
		}
		return cust;
	}

}
