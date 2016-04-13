package com.caicai.www.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	
	private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		
		Connection connection;
		
		Session session;
		
		Destination destination;
		
		MessageConsumer messageConsumer;
		
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKERURL);
		
		try {
			connection = connectionFactory.createConnection();
			
			connection.start();
			
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			destination = session.createQueue("HeloWorld");
			
			messageConsumer = session.createConsumer(destination);
			
			while(true){
				TextMessage textMessage = (TextMessage) messageConsumer.receive(10000);
				if(textMessage != null){
					System.out.println("接受到的信息："+ textMessage.getText());
				} else {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
