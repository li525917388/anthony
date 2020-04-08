package com.ldh.design.factory;

/**
 * 抽象工厂
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public interface AbstractFactory {

	/**
	 * 创建手机
	 * @return
	 */
	Company createPhone();
	
	/**
	 * 创建电脑
	 * @return
	 */
	Company createComputer();
}
