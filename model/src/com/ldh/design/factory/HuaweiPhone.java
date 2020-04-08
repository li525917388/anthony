package com.ldh.design.factory;

/**
 * 
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class HuaweiPhone implements Company {

	@Override
	public void sell() {
		System.out.println("华为卖手机");
	}

}
