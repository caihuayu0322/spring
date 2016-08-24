package com.caicai.www.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "bean:name=testbean", description = "My managed bean", log = true, logFile = "jmx.log")
public class AnnotationTestBean {

	private String name;
	
	private String age;

	@ManagedAttribute(description = "The Name Attribute", currencyTimeLimit = 15)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManagedOperation(description = "add two num")
	@ManagedOperationParameters(value = { @ManagedOperationParameter(name = "x", description = ""),
			@ManagedOperationParameter(name = "y", description = "") })
	public int add(int x, int y) {
		return x + y;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
