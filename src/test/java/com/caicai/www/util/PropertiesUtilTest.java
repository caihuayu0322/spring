package com.caicai.www.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesUtilTest {

	public Properties properties;

	public PropertiesUtilTest() throws IOException {
		properties = new Properties();
		InputStream is = PropertiesUtilTest.class.getClassLoader().getResourceAsStream("test.properties");
		try {
			properties.load(is);
		} finally {
			is.close();
		}
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) throws Exception {
		PropertiesUtilTest properties = new PropertiesUtilTest();
		for (Entry<Object, Object> it : properties.properties.entrySet()) {
			System.out.println(it.getKey());
		}
		System.out.println(String[].class);
	}
}
