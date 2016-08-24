package com.caicai.www.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;

public class ClassTest {

	public static void classLoaderTest() {
		//#1 方法一
//		ClassLoader loader = ClassLoader.getSystemClassLoader();
//		URL resource0 = loader.getResource("G:\\workspace\\spring\\spring.iml");
//		System.out.println(resource0.getFile());
		//#2 方法二
		URL resource = ClassLoader.getSystemResource("G:\\workspace\\spring\\spring.iml");
		try {
			Enumeration resource1 = ClassLoader.getSystemResources("");
			Enumeration<Object> a = new Enumeration<Object>() {
				
				@Override
				public Object nextElement() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public boolean hasMoreElements() {
					// TODO Auto-generated method stub
					return false;
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resource.getFile());
	}
	
	public <T> T test(Class<T> target){
		return null;
	}
	
	public static void methodTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method[] methods = ClassTest.class.getDeclaredMethods();
		Method method = methods[0];
		method.invoke(new Object());
	}

	public static void main(String[] args) {
		classLoaderTest();
	}
}
