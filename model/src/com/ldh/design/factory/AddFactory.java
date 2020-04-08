package com.ldh.design.factory;

/**
 * 加法工厂
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class AddFactory implements Factory {

	@Override
	public Operation createOperation() {
		System.out.println("加法运算");
        return new AddOperation();
	}

}
