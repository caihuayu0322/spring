package com.caicai.www.concurrent;

import java.util.Date;

public class DeamonTest {
	
	public static void main(String[] args) throws InterruptedException {
	 Runnable a = new Runnable() {
			public void run() {
				while(true){
					System.out.println("I am running at:"+new Date()+"i am deamon");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread b = new Thread(a);
		b.setDaemon(true);
		b.start();
//		new Thread(a).start();
		Thread.sleep(3000);
		System.out.println("main thread exit;");
		
	}

}
