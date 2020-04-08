package com.ldh.algorithm.rbt;

/**
 * 红黑树节点类
 * @author Li Dehuan
 * @date 2020年3月17日
 *
 */
public class RBNode<T extends Comparable<T>> {

	boolean color;//颜色
	
	T value;//值
	
	RBNode<T> left;//左子节点
	
	RBNode<T> right;//右子节点
	
	RBNode<T> parent;//父节点
	
	public RBNode(boolean color,T value,RBNode<T> parent,RBNode<T> left,RBNode<T> right){
		this.color = color;
		this.value = value;
		this.parent = parent;
		this.right = right;
		this.left = left;
	}
	
	public T getValue(){
		return value;
	}
	
	//打印节点的关键值和颜色信息
	public String toString(){
		return value + (this.color == true ? "R":"B");
	}
}
