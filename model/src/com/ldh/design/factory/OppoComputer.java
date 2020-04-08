package com.ldh.design.factory;

public class OppoComputer implements Company {

	@Override
	public void sell() {
		System.out.println("oppo卖电脑");
	}

}
