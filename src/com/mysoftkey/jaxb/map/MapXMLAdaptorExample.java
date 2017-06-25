package com.mysoftkey.jaxb.map;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class MapXMLAdaptorExample {

 private static final String XML_PATH = "./docs/customerMap.xml";

 /**
  * @param args
  * @throws Exception
  */
 public static void main(String[] args) throws Exception {
  try {
   unmarshalCustomer();
  } catch (Exception e) {
   e.printStackTrace();
  }

 }

 /**
  * @throws JAXBException
  * @throws PropertyException
  */
 private static Customer unmarshalCustomer() throws JAXBException, PropertyException {
  JAXBContext jc = marshaCustomer();

  Unmarshaller unmarshaller = jc.createUnmarshaller();
  Customer unMarshCustomer = (Customer) unmarshaller.unmarshal(new File(XML_PATH));

  System.out.println(unMarshCustomer.getName());
  return unMarshCustomer;
 }

 /**
  * @return
  * @throws JAXBException
  * @throws PropertyException
  */
 private static JAXBContext marshaCustomer() throws JAXBException, PropertyException {
  JAXBContext jc = JAXBContext.newInstance(Customer.class);

  Address billingAddress = new Address();
  billingAddress.setStreet("B-672, DDA Flats, Bindapur, Dwarka");
  billingAddress.setCity("New Delhi");

  Address shippingAddress = new Address();
  shippingAddress.setStreet("Street no 2");
  shippingAddress.setCity("Banglore");

  Customer customer = new Customer();
  customer.getAddressMap().put("billingAddress", billingAddress);
  customer.getAddressMap().put("shippingAddress", shippingAddress);
  customer.setId(123);
  customer.setName("Ranjeet Jha");

  Marshaller marshaller = jc.createMarshaller();
  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
  
  marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

  // write to console
  marshaller.marshal(customer, System.out);

  // Write to File
  marshaller.marshal(customer, new File(XML_PATH));
  return jc;
 }

}
