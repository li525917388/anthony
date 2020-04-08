package com.ldh.design.factory;

/**
 * 乘法计算
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class MulOperation implements Operation {

	@Override
	public double getResult(double numberA, double numberB) throws Exception {
		// 乘法计算
		return numberA * numberB;
	}

}
