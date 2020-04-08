package com.ldh.design.factory;

/**
 * 华为电脑
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class HuaweiComputer implements Company {

	@Override
	public void sell() {
		System.out.println("华为卖电脑");
	}

}
