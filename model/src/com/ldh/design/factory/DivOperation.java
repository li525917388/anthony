package com.ldh.design.factory;

/**
 * 除法操作类
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class DivOperation implements Operation {

	// 除法计算
	@Override
	public double getResult(double numberA, double numberB) throws Exception {
		
		if (numberB == 0) {
            throw new Exception("除数不能为0！");
        }
		
        return numberA / numberB;
	}

}
