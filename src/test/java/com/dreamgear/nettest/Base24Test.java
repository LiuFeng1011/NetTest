package com.dreamgear.nettest;
import java.util.Date;

public class Base24Test {
	static String table = "abcdefABCDEFGHIJK12345";
	
	public static void main( String[] args ) throws Exception
    {
		
		Date date = new Date();
		long times = date.getTime()/1000;//时间戳
		
		int num = 34264353;
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (num & 0xFF);
		bytes[1] = (byte) ((num >> 8) &  0xFF);
		bytes[2] = (byte) ((num >> 16) &  0xFF);
		bytes[3] = (byte) ((num >> 24) &  0xFF);

		String b24 =enBase24(bytes);
		System.out.println("uncode value : " + b24);
		byte[] deb24 = deBase24(b24);
		int val = ((int)(deb24[0] & 0xFF) << 0) +
				((int)(deb24[1] & 0xFF) << 8) + 
				((int)(deb24[2] & 0xFF) << 16) + 
				((int)(deb24[3] & 0xFF) << 24);
		System.out.println("decode value : " + val);
		
    }
	
	public static String enBase24(byte[] datas){
		
		int slength = table.length();
		
		String result = "";
		
		for(int i = 0 ;i < datas.length ; i ++){
			int n = ((int)(datas[i] & 0xff) );
			int m1 = n % slength ;
			result+= table.charAt(m1);
			int m2 = (int)(n / slength);//128/length < length 这里限制编码表最小长度12位
			result+= table.charAt(m2);
		}
		
		return result;
	}

	public static byte[] deBase24(String base24String){
		int slength = base24String.length() / 2;
		byte[] bytes = new byte[slength];
		
		for(int i = 0 ;i < slength ; i ++){
			int index1 = table.indexOf(base24String.charAt(i*2));
			int index2 = table.indexOf(base24String.charAt(i*2+1));
			int n = (index1 + index2 * table.length() );
			bytes[i] = (byte) n;
		}
		
		return bytes;
	}
	
}
