package com.ldh.design.sigleton;

/**
 * 单例模式（饥汉）
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class SigletonHunger {

	private static SigletonHunger hunger = new SigletonHunger();
	
	private SigletonHunger(){}
	
	public static SigletonHunger create(){
		
		return hunger;
	}
}
