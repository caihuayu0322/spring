package com.caicai.www.jni;

public class MyNative {
	
	public void showParms(String s, int i, boolean b) {
		showParms0(s, i, b);
	}

	private native void showParms0(String s, int i, boolean b);

	static {
		System.load("G:\\workspace\\spring\\src\\main\\resources\\lib\\MyNative.dll");
	}
//	static{
//		System.load("C:\\Windows\\winsxs\\amd64_microsoft-windows-msvcrt_31bf3856ad364e35_6.1.7601.17744_none_2f5acf97b59df60f\\msvcrt.dll");
//	}
	
	public static void main(String[] args) {
		new MyNative().showParms("caicai", 2, true);
	}
}
