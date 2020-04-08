package com.ldh.design.factory;

/**
 * 加法操作类
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class AddOperation implements Operation {

	
	@Override
	public double getResult(double numberA, double numberB) throws Exception {
		// 计算加法
		return numberA + numberB;
	}

}
