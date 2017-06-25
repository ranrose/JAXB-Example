/**
 * 
 */
package com.mysoftkey.jaxb.namespace;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ranjeet.Jha
 * 
 */
@XmlRootElement(namespace = "http://mysoftkey.com/jaxb") // , name="mycustomer"
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

	private String name;
	private int age;
	private int id;
	
	@XmlElementWrapper(name = "customerAddress")
 @XmlElement(name = "address")
	private List<Address> addresses;

	public String getName() {
		return name;
	}
	
	public Customer() {
		
	}
	
public Customer(int id, String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
/**
 * this method add the address into customer.
 * 
 * @param address
 */
public void addAddrss(Address address) {
	if (addresses == null || addresses.size() == 0) {
		addresses = new ArrayList<Address>();
	}
	addresses.add(address);
}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	//@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

}