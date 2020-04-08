package com.ldh.design.factory;

/**
 * 减法操作类
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class SubOperation implements Operation {

	@Override
	public double getResult(double numberA, double numberB) throws Exception {
		// 减法计算
		return numberA-numberB;
	}

}
