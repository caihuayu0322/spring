package com.caicai.www.jmx;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.ReflectionException;

public class HelloWorld implements HelloWorldMBean{

	private String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name ;
	}

	@Override
	public void printHello() {
		// TODO Auto-generated method stub
		System.out.println(name);
	}

	@Override
	public void printHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
	}


}
