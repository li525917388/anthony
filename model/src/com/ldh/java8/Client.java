package com.ldh.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Client {

	public static void main(String[] args) {
		
		Car car = Car.create(Car::new);
		
		Function<String, Car> f = Car::new;
		f.apply("ldh");
		
		final List< Car > cars = Arrays.asList( car );
		
		cars.forEach(Car::collide);
		
		cars.forEach(Car::repair);
		
		//final Car police = Car.create( Car::new );
		cars.forEach( System.out::println);
		
	}
}
