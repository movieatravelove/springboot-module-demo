package com.zhang.api.utils;

/** 
 * 随机数工具类 
 * @author liuyazhuang 
 * 
 */  
public final class RandomUtils {  
	
	public static void main(String[] args) {
		System.out.println(getRandom(16));
	}
    /** 
     * 获取指定位数的随机数 
     * @param num 
     * @return 
     */  
    public static String getRandom(int len){  
    	len = len>0?len: 32;
		String str="ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";   
		int maxPos = str.length();
		String pwd ="";
		for (int i = 0; i < len; i++) {
			pwd += str.charAt((int)(Math.floor(Math.random() * maxPos)));
		}
		    return pwd;
    }
    public static String createOrderId(String machineId) {
		String orderId = machineId + (System.currentTimeMillis() + "").substring(1)
				+ (System.nanoTime() + "").substring(7, 10);
		return orderId;
	}
}  