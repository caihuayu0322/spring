package com.caicai.www.jms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketFactory2 {

	public void connect(String ip,int port){
		try {
			System.out.println("socket并发连接");
			Socket socket = new Socket(ip, port);
//			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
			StringBuffer stringBuffer = new StringBuffer();
			FileInputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\candao.2016-04-09.log");
			
			byte[] buffer = new byte[1024];
			
			while (input.read(buffer) != -1) {
				stringBuffer.append(new String(buffer));
			}
			
			input.close();
			writer.write(stringBuffer.toString());
			
			writer.flush();
			writer.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		while(true){
			new Thread(new Runnable() {
				public void run() {
					new SocketFactory2().connect("10.66.21.3", 61616);
				}
			}).start();			
		}
	}
}
