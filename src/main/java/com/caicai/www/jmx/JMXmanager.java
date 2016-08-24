//package com.caicai.www.jmx;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.management.MBeanServerConnection;
//import javax.management.remote.JMXConnector;
//import javax.management.remote.JMXConnectorFactory;
//import javax.management.remote.JMXServiceURL;
//
//public class JMXmanager {
//	
//	public static MBeanServerConnection createMBeanServer(String ip,String jmxport,String username,String password){
//		
//		try {
//			String jmxURL = "service:jmx:rmi://jndi/rmi://" + ip + ":" + jmxport + "/jmxrmi";
//			
//			JMXServiceURL serviceURL = new JMXServiceURL(jmxURL);
//			
//			Map map = new HashMap<>();
//			
//			String [] credentials = new String [] {username,password};
//			
//			map.put("jmx.remote.credentials", credentials);
//			
//			JMXConnector connector = JMXConnectorFactory.connect(serviceURL,map);
//			
//			MBeanServerConnection mbsc = connector.getMBeanServerConnection();
//			
//			return mbsc;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//	
//	
//	
//
//}
