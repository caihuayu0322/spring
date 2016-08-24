package com.caicai.www.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class ParseTest {

	public static void main(String[] args) throws Exception {
//		Map obj = new HashMap<>();
//		Map buffer = new HashMap<>();
//		buffer.put("a", "haha");
//		obj.put("aa", buffer);
//		doParse(obj, new String[]{"aa","a"});
		
		AA aa = new AA();
		A a = new A();
		
		a.setAa(aa);
		aa.setA("23232323");
		
		doParse(a, new String[]{"aa.a"});
	}

	private static void doParse(Object obj ,String[] datas) throws Exception {
		String[] buffer = new String[datas.length];
		for (int i = 0; i < datas.length; i++) {
			String[] pros = StringUtils.delimitedListToStringArray(datas[i], ".");
			Object temp = obj;
			for (int j = 0; j < pros.length; j++) {
//				temp.getClass()
				Field fields = temp.getClass().getDeclaredField(pros[j]);
				fields.setAccessible(true);
				temp = fields.get(temp);
			}
			buffer[i] = String.valueOf(temp);
		}
		for (int i = 0; i < buffer.length; i++) {
			System.out.println(buffer[i]);
		}
	}
}
