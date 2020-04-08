package com.ldh.algorithm.rbt;

public class Test {

	public static void main(String[] args) {
		
		RedBlackTree<Integer> rbt = new RedBlackTree<>();
		
		rbt.insert(5);
		rbt.insert(4);
		rbt.insert(1);
		rbt.insert(2);
		rbt.insert(8);
		rbt.insert(5);
		rbt.insert(3);
		rbt.insert(3);
		rbt.insert(0);
		
		System.out.println(rbt);
	}
}
