package com.caicai.www.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		
		list.add(new CaiCai().init());
		list.add(new CaiCai().init());
		System.out.println(list.toArray());
		System.out.println(Arrays.toString(list.toArray()));
	}
}
