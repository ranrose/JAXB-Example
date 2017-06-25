/**
 * 
 */
package com.mysoftkey.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is simple POJO class with minimum annotation
 * which will be used for JAXB 2.0 marshaling and un-marshaling.
 * 
 * @author Ranjeet.Jha
 * 
 */
@XmlRootElement
public class Customer {

	private String name;
	private int age;
	private int id;

	public String getName() {
		return name;
	}

	@XmlElement(/*name="myname"*/)
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
}