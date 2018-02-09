package com.dreamgear.nettest;
import java.util.Date;
public class Redeem {
	
	//
	static String targetstring = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXZY23456789abckdefc";
	
	public static void main( String[] args ) throws Exception
    {
		
		Date date = new Date();
		long times = date.getTime()/1000;//时间戳
		int shorttime = (int)(times-1262275200);
		System.out.println(shorttime);
		System.out.println(Integer.MAX_VALUE - shorttime);
		System.out.println((Integer.MAX_VALUE - times) / 60/60/24/365);
		
		System.out.println("=======================");
		create(shorttime,3,14);
    }
	
	/**
	 * 生成兑换码
	 * @param time
	 * @param id
	 * @param count
	 * @return
	 */
	public static byte[] create(int time,int codecount,int codelength) {
		//8位的数据总长度
		int fullcodelength = codelength * 6 / 8; 
		//随机码对时间和id同时做异或处理，所以不会有重复出现
		//时间1，id4，随机码n,校验码1v (codelength*6 - 11*8) / 8
		int randcount = fullcodelength - 6;//随机码有多少个
		
		//如果随机码小于0 不生成
		if(randcount <= 0 ) {
			return null;
		}
		for(int i = 0 ; i < codecount ; i ++) {

			byte[] linkbytes = new byte[fullcodelength];
			int copycount = 0;
			byte[] timebytes = new byte[] { (byte)(time & 0xFF)};
			CopyByte(linkbytes,timebytes,copycount);
			copycount += 1;
			
			byte[] idbytes = IntToByteArray(i);
			CopyByte(linkbytes,idbytes,copycount);
			copycount += 4;
			
			byte[] randbytes = new byte[randcount];
			for(int j = 0 ; j  < randcount ; j ++) {
				randbytes[j] = (byte)(Math.random() * Byte.MAX_VALUE);
			}
			CopyByte(linkbytes,randbytes,copycount);
			copycount += randcount;
			
			//使用随机码的最后一位作为校验位
			byte verify = randbytes[randbytes.length - 1];
			linkbytes[copycount] = verify;
			copycount += 1;
			
			//使用随机码与时间和ID进行异或
			for(int j = 0 ; j < 5 ; j ++) {
				linkbytes[j] = (byte) (linkbytes[j] ^ (linkbytes[5 + j % randcount]));
			}
			
			
			byte[] bytes = new byte[codelength];
			
			//按6位一组复制给最终数组
			for(int j = 0 ; j < linkbytes.length ; j ++) {
				for(int k = 0 ; k < 8 ; k ++) {
					int sourceindex = j*8+k;
					int targetindex_x = sourceindex / 6;
					int targetindex_y = sourceindex % 6;
					byte placeval = (byte)Math.pow(2, k);
					byte val = (byte)((linkbytes[j] & placeval) == placeval ? 1:0);
					//复制每一个bit
					bytes[targetindex_x] = (byte)(bytes[targetindex_x] | (val << targetindex_y));
				}
			}
			
			System.out.println(bytes.toString());
			System.out.println("byte length : " + bytes.length);
			String s = "";
			//编辑最终数组生成字符串
			for(int j = 0 ; j < bytes.length ; j ++) {
				s += targetstring.charAt(bytes[j]);
			}
			System.out.println(s + " / " + s.length() );
			System.out.println("----------");
		}
		
		return null;
	}
	
	public static void CopyByte(byte[] target,byte[] source,int position) {
		for(int i= 0 ; i < source.length ; i ++) {
			if(target.length <= i) return;
			target[position + i] = source[i];
		}
	}
	
	public static byte[] IntToByteArray(int a) {   
		return new byte[] {   
		        (byte) ((a >> 24) & 0xFF),   
		        (byte) ((a >> 16) & 0xFF),      
		        (byte) ((a >> 8) & 0xFF),      
		        (byte) (a & 0xFF)   
		    };   
	} 
}
