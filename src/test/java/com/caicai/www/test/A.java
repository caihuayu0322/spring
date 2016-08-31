package com.caicai.www.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class A {

	private AA aa;

	public AA getAa() {
		return aa;
	}

	public void setAa(AA aa) {
		this.aa = aa;
	}

	
	public static void main(String[] args) throws ParseException {
//		String a = "1466340626";
//		  Long timestamp = Long.parseLong(a)*1000;
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        System.out.println(sd.format(new Date(timestamp)));
		Map<String, Object> b = new HashMap<>();
		A a = (A)b.get("a");
		System.out.println(a);
	}
}
