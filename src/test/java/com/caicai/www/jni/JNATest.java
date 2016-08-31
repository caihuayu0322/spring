package com.caicai.www.jni;

import java.util.HashMap;
import java.util.Map;

import com.caicai.www.test.A;

public class JNATest {
	//源生
	public native void hello(String a, int b, boolean c);
	
	//源生
//	static {
//		System.loadLibrary("Hello");
//	}

	public static void main(String[] args) {
//		new JNITest().hello("caicai", 27, true);
//		System.out.println(System.getProperty("java.library.path"));
		Map<String, Object> map = new HashMap<>();
		map.put("23", new A());
		CLibrary.INSTANCE.printf("caicai%s", map);
	}
}
