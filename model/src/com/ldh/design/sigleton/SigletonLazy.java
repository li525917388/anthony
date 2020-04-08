package com.ldh.design.sigleton;

/**
 * 单例模式 （懒汉）
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class SigletonLazy {

	private static SigletonLazy sigleton;
	
	private SigletonLazy(){
		
	}
	
	public static SigletonLazy create(){
		
		if(sigleton == null){
			
			sigleton = new SigletonLazy();
		}
		
		return sigleton;
	}
}
