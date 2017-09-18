package com.emis.util;

/**
 * 简单数据类型转化方法
 * @author Anthony
 *
 */
public class SimpleUtil {

	/**
	 * 将 String 类型转化为 int 类型
	 * @param str
	 * @return
	 */
	public static Integer toInteger(String str){
		
		/**
		 * 基
		 */
		Integer m = 0 ;
		
		try {
			
			m = Integer.valueOf(str) ;
			
		} catch (Exception e) {
			
		}
		
		return m;
	}
	
	
	/**
	 * 将 String 类型转化为 int 类型
	 * @param str 目标数据
	 * @param temp  备用数据
	 * @return
	 */
	public static Integer toInteger(String str,int temp){
		
		/**
		 * 基
		 */
		Integer m = 0 ;
		
		try {
			
			m = Integer.valueOf(str) ;
			
		} catch (Exception e) {
			
			m = temp ;
			
		}
		
		return m;
	}
}
