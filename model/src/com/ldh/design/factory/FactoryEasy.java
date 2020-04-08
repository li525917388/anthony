package com.ldh.design.factory;

/**
 * 简单工厂模式
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class FactoryEasy {

	
	public static Operation createOperation(String name){
		
		Operation operationObj = null;
        
		switch (name) {
            case "+":
                operationObj = new AddOperation();
                break;
            case "-":
                operationObj = new SubOperation();
                break;
            case "*":
                operationObj = new MulOperation();
                break;
            case "/":
                operationObj = new DivOperation();
                break;
        }
        return operationObj;
	}
}
