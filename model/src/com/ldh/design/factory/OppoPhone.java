package com.ldh.design.factory;

/**
 * oppo手机公司
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class OppoPhone implements Company {

	@Override
	public void sell() {
		System.out.println("oppo卖手机");
	}

}
