package com.ldh.design.sigleton;

public class Client {

	
	public static void main(String[] args) {
		
		//懒汉模式
		SigletonLazy.create();
		
		//饿汉模式
		SigletonHunger.create();
		
		//懒汉模式，线程安全
		SigletonLazyPlus.create();

	}
}
