package com.caicai.www.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloWorldAgent {

	public static void main(String[] args) throws Exception {
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		
		ObjectName helloWorldName = new ObjectName("caicai:name=caicai,str=HelloWorld!");
		server.registerMBean(new HelloWorld(), helloWorldName);
		
		ObjectName adaptorName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
		HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer();
		server.registerMBean(adaptorServer, adaptorName);
		
		adaptorServer.start();
		
		System.out.println("start...");
		
	}
}
