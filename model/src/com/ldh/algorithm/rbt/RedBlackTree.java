package com.ldh.algorithm.rbt;

public class RedBlackTree<T extends Comparable<T>> {

	private RBNode<T> root;		// 根节点
	
	
	public void insert(T value) {
		RBNode<T> node = new RBNode<T>(true, value, null, null, null);
	    if(root != null){
	        insert(node);
	    }else{
	    	root = node;
	    	node.color = false;
	    }
	}
	

	private void insert(RBNode<T> node) {
		RBNode<T> current = null;//表示最后node的父节点
	    RBNode<T> x = this.root;//用来向下搜索
	     
	    //1.找到插入位置
	    while(x != null){
	        current = x;
	        int cmp = node.value.compareTo(x.value);
	        if(cmp < 0){
	            x = x.left;
	        }else{
	            x = x.right;
	        }
	    }
	    node.parent = current;//找到了插入的位置，将当前current作为node的父节点
	     
	    //2.接下来判断node是左子节点还是右子节点
	    if(current != null){
	        int cmp = node.value.compareTo(current.value);
	        if(cmp < 0){
	            current.left = node;
	        }else{
	            current.right = node;
	        }
	    }else{
	        this.root = node;
	    }
	     
	    //3.平衡化操作
	    insertFixUp(node);
	  
	}

	
	private void insertFixUp(RBNode<T> node) {
		// TODO Auto-generated method stub
		//平衡化操作
	    if (isRed(node.right) && !isRed(node.left)) rotateLeft(node);
	    if (isRed(node.left) && isRed(node.left.left)) rotateRight(node);
	    if (isRed(node.left) && isRed(node.left)) flipColor(node);
	}


	private void flipColor(RBNode<T> node) {
		node.color = !node.color;
	}


	private void rotateRight(RBNode<T> y) {
		RBNode<T> x = y.left;
	    y.left = x.right;
	    if(x.right != null){
	        x.right.parent = y;
	    }
	     
	    //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
	    x.parent = y.parent;
	    if(y.parent == null){
	        this.root = x;//如果y的父节点为空(即y为根节点)，则旋转后将x设为根节点
	    }else{
	        if(y == y.parent.left){//如果y是左子节点
	            y.parent.left = x;//则将x也设置为左子节点
	        }else{
	            y.parent.right = x;//否则将x设置为右子节点
	        }
	    }
	     
	    //3. 将x的左子节点设为y，将y的父节点设为y
	    x.right = y;
	    y.parent = x;
	}


	private void rotateLeft(RBNode<T> x) {
		//1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
	    RBNode<T> y = x.right;
	    x.right = y.left;
	    if(y.left != null){
	        y.left.parent = x;
	    }
	     
	    //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
	    y.parent = x.parent;
	    if(x.parent == null){
	        this.root = y;//如果x的父节点为空(即x为根节点)，则将y设为根节点
	    }else{
	        if(x == x.parent.left){//如果x是左子节点
	            x.parent.left = y;//则也将y设为左子节点 
	        }else{
	            x.parent.right = y;//否则将y设为右子节点 
	        }
	    }
	     
	    //3. 将y的左子节点设为x，将x的父节点设为y
	    y.left = x;
	    x.parent = y;
	}


	private boolean isRed(RBNode<T> left) {
		if(left == null) return false;
		
		return left.color;
	}


	/**
	 * 左旋示意图：对节点x进行左旋 
	 *     p                       p 
 	 *    /                       / 
 	 *   x                       y 
 	 *  / \                     / \ 
 	 * lx  y      ----->       x  ry 
	 *    / \                 / \ 
	 *   ly ry               lx ly 
	 * 左旋做了三件事： 
	 * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时) 
 	 * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右) 
 	 * 3. 将y的左子节点设为x，将x的父节点设为y 
	 * @param x
	 */
	private void leftRotate(RBNode<T> x){
		
		RBNode<T> y = x.right;
	    x.right = y.left;
	    if(y.left != null){
	        y.left.parent = x;
	    }
	     
	    //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
	    y.parent = x.parent;
	    if(x.parent == null){
	        this.root = y;//如果x的父节点为空(即x为根节点)，则将y设为根节点
	    }else{
	        if(x == x.parent.left){//如果x是左子节点
	            x.parent.left = y;//则也将y设为左子节点 
	        }else{
	            x.parent.right = y;//否则将y设为右子节点 
	        }
	    }
	     
	    //3. 将y的左子节点设为x，将x的父节点设为y
	    y.left = x;
	    x.parent = y;
	}
}
