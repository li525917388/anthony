package com.ldh.design.factory;

public class Client {

	
	public static void main(String[] args) throws Exception {
		
		//简单工厂
		factoryEasy();
        
		//工厂方法
		factoryMethod();
		
		//抽象工厂
		factoryAbstract();
       
	}
	
	/**
	 * 简单工厂
	 * @throws Exception
	 */
	public static void factoryEasy() throws Exception{

		System.out.println("===== 简单工厂 ==========");
		
		Operation add = FactoryEasy.createOperation("+");
        Operation sub = FactoryEasy.createOperation("-");
        Operation mul = FactoryEasy.createOperation("*");
        Operation div = FactoryEasy.createOperation("/");

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(16, 6));
        System.out.println(mul.getResult(3, 3));
        System.out.println(div.getResult(12, 3));
		        
	}
	
	
	/**
	 * 工厂方法
	 * @throws Exception
	 */
	public static void factoryMethod() throws Exception{

		System.out.println("===== 工厂方法 ==========");
		
		// 使用反射机制实例化工厂对象，因为字符串是可以通过变量改变的
        Factory addFactory = (Factory) Class.forName("com.ldh.design.factory.AddFactory").newInstance();
        Factory subFactory=(Factory) Class.forName("com.ldh.design.factory.SubFactory").newInstance();

        // 通过工厂对象创建相应的实例对象
        Operation add = addFactory.createOperation();
        Operation sub = subFactory.createOperation();

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
		
	}
	
	
	
	/**
	 * 抽象工厂
	 */
	public static void factoryAbstract() {
		System.out.println("===== 抽象工厂 ==========");
		
		AbstractFactory huawei = new HuaweiFactor();
		huawei.createComputer().sell();
		huawei.createPhone().sell();
		
		AbstractFactory oppo = new OppoFactory();
		oppo.createComputer().sell();
		oppo.createPhone().sell();
		
	}
}
