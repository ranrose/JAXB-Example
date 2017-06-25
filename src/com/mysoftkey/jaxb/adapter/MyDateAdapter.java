/**
 * 
 */
package com.mysoftkey.jaxb.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * This is Adaptor class which has main responsibility 
 * to convert from java.util.Date to format string of date.
 * 
 * @author ranjeet.jha
 *
 */
public class MyDateAdapter extends XmlAdapter<String, Date> {
 private final DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

 @Override
 public Date unmarshal(String xml) throws Exception {
  return dateFormat.parse(xml);
 }

 @Override
 public String marshal(Date object) throws Exception {
  return dateFormat.format(object);
 }
}
