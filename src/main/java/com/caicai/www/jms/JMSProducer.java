package com.caicai.www.jms;

import java.io.File;
import java.io.FileInputStream;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

public class JMSProducer {

	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	
	private static final String BROKEURL = "failover://(tcp://127.0.0.1:61616?wireFormat.maxInactivityDuration=50000)?initialReconnectDelay=100";
	
	private static final int SENDNUM = 1;
	
	public static void main(String[] args) {
		ActiveMQConnectionFactory connectionFactory;
		
		Connection connection = null;
		Session session;
		
		Topic topic;
		
		Destination destination;
		
		MessageProducer messageProducer;
		
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();
			
			//设置
//			RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
//			redeliveryPolicy.setBackOffMultiplier(backOffMultiplier);
			
//			connectionFactory.setRedeliveryPolicy();
			
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			destination = session.createQueue("HelloWorld");
			
			messageProducer = session.createProducer(destination);
			
//			topic = session.createTopic("HelloWorldTopic");
			
//			session.c
			
			sendMessage(session, messageProducer);		
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection!= null){
				try {
//					Thread.sleep(300000);
					connection.close();
				} catch (Exception e) {
					System.out.println(13);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception{
		for (int i = 0; i < JMSProducer.SENDNUM; i++) {
//			File file = new File("C:\\Users\\Administrator\\Desktop\\candao.2016-04-09.log");
			StringBuffer stringBuffer = new StringBuffer();
			FileInputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\t_biz_log.sql");
			
			byte[] buffer = new byte[1024];
			
			while (input.read(buffer) != -1) {
				stringBuffer.append(new String(buffer));
			}
			
			input.close();
			
			TextMessage message = session.createTextMessage(stringBuffer.toString());
			System.out.println("发送消息：AvtiveMq 发送消息" + i);
			messageProducer.send(message, Message.DEFAULT_DELIVERY_MODE, Message.DEFAULT_PRIORITY, 1000000);;
			System.out.println("发送消息：AvtiveMq 消息发送成功！");
		}
	}
}
