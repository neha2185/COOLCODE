package com.java.interview;

public class BinaryTree {
	
	Node root;
	
	public static void main(String[] args) {
		//Create Tree and add nodes
		BinaryTree btree = new BinaryTree();
		btree.add(6);
		btree.add(4);
		btree.add(8);
		btree.add(3);
		btree.add(5);
		btree.add(7);
		btree.add(9);
		
		System.out.println("btree contains element 6: " + btree.containsNode(6));
		System.out.println("btree contains element 10: " + btree.containsNode(10));
	}
	
	private void add(int val) {
		root = addRecursive(root,val);
	}

	private Node addRecursive(Node currentNode,int value) {
		if(currentNode == null) 
			return new Node(value);
		
		if(value < currentNode.value) 
			currentNode.left = addRecursive(currentNode.left, value);
		else if(value > currentNode.value) 
			currentNode.right = addRecursive(currentNode.right, value);
		else
			return currentNode;
		
		return currentNode;
	}
	
	private boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node currentNode, int value) {
		if(currentNode==null)
			return false;
		
		if(currentNode.value == value) 
			return true;
		
		return value < currentNode.value ? containsNodeRecursive(currentNode.left, value) : containsNodeRecursive(currentNode.right, value);
	}
}
