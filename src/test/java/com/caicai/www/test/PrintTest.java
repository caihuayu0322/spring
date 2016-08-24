package com.caicai.www.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class PrintTest {

	public static byte[] getFd8Font() { /* ����Ŵ�һ�� */
		byte[] fd_font = new byte[3];
        fd_font[0] = 0x1d;
        fd_font[1] = 0x21;
        fd_font[2] = 17;

        return fd_font;
    }
	
	public static byte[] getTestFont(){
		byte[] fd_font = new byte[3];
        fd_font[0] = 0x1b;
        fd_font[1] = 21;
        fd_font[2] = 0;

        return fd_font;
	}
	
	//����Ŵ����������֣�Ӣ�ģ����ֶ�֧�֣�
    public static byte[] longitudinalDouble(){
	 	 byte[] result = new byte[3];
	      result[0] = 29;
	      result[1] = 33;
	      result[2] = 4;
	      return result;
	  }
	
	public static String alignCenter()
    {
    		byte[] result = new byte[3];
        result[0] = 27;
        result[1] = 97;
        result[2] = 1;
        return new String(result);
    }
	
	/**
     * 左对齐
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static String alignLeft()
    {
    		byte[] result = new byte[3];
        result[0] = 27;
        result[1] = 97;
        result[2] = 0;
        return new String(result);
    }
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("10.66.18.3", 9100);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter writer = null;
		writer = new OutputStreamWriter(out, "GBK");
//		writer.write(27);
//		writer.write(100);
//		writer.write(4);
//		writer.write(10);
		writer.flush();
//		out.write(getTestFont());
//		out.write(longitudinalDouble());
		out.write(getFd8Font());
		writer.write(alignCenter());
		writer.write("------------------------------------------\r\n");
		String a = "sfsdf白汤梭边鱼2323\r\n";
		byte[] bytes = a.getBytes("Unicode");
		
		String a1 = new String(bytes, 0, a.getBytes("Unicode").length, "Unicode");
		
		writer.write(a1);
		writer.flush();
		writer.write(alignLeft());
		writer.write("哈哈哈哈哈哈");
		writer.write(27);
		writer.write(100);
		writer.write(4);
		writer.write(10);
		writer.flush();
		out.write(new byte[] { 0x1B, 0x69 });// ��ֽ
		out.flush();
		writer.close();
		out.close();
		socket.close();
	}
}
