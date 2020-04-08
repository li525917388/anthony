package com.ldh.design.factory;

/**
 * 华为工厂
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class HuaweiFactor implements AbstractFactory {

	@Override
	public Company createPhone() {
		// TODO Auto-generated method stub
		return new HuaweiPhone();
	}

	@Override
	public Company createComputer() {
		// TODO Auto-generated method stub
		return new HuaweiComputer();
	}

	
}
