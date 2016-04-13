package com.caicai.www.test;

public class CaiCai {

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public CaiCai init(){
		this.id = "3";
		this.name = "caicai";
		return this;
	}
}
