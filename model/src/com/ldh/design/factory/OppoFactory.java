package com.ldh.design.factory;

/**
 * oppo工厂实现类
 * @author Li Dehuan
 * @date 2019年7月1日
 *
 */
public class OppoFactory implements AbstractFactory {

	@Override
	public Company createPhone() {
		return new OppoPhone();
	}

	@Override
	public Company createComputer() {
		// TODO Auto-generated method stub
		return new OppoComputer();
	}

}
