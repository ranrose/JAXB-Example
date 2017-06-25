package com.mysoftkey.jaxb.map;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
// @XmlType(namespace="http://www.mysoftkey.com/type")
public class Customer {

	private long id;
	private String name;

	// this is optional
	private Map<String, Address> addressMap = new HashMap<String, Address>();

	@XmlJavaTypeAdapter(MapAdapter.class)
	// @XmlElement(name="addresses")
	public Map<String, Address> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, Address> addressMap) {
		this.addressMap = addressMap;
	}

	@XmlAttribute(name = "cust_id")
	public long getId() {
		return id;
	}

	// @XmlElement
	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
