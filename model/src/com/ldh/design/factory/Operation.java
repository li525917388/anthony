package com.ldh.design.factory;

/**
 * 操作类型接口
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public interface Operation {

	/**
	 * 得到运算结果
	 * @param numberA
	 * @param numberB
	 * @return
	 * @throws Exception
	 */
	public double getResult(double numberA,double numberB) throws Exception;
}
