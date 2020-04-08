package com.ldh.design.sigleton;

/**
 * 单例模式 （懒汉）</br>
 * 兼顾线程安全和效率的写法</br>
 * 双重检查锁
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class SigletonLazyPlus {

	private static SigletonLazyPlus sigleton;
	
	private SigletonLazyPlus(){
		
	}
	
	public static SigletonLazyPlus create(){
		
		if(sigleton == null){
			
			synchronized (SigletonLazyPlus.class) {
				
				if(sigleton == null) 
					sigleton = new SigletonLazyPlus();
			}
			
		}
		
		return sigleton;
	}
}
