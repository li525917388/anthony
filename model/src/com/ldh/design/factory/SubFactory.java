package com.ldh.design.factory;

/**
 * 减法工厂
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class SubFactory implements Factory {

	@Override
	public Operation createOperation() {
		System.out.println("减法运算");
        return new SubOperation();
	}

}
