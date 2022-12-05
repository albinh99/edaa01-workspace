package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		BinaryNode<E> temp = new BinaryNode<>(x);
		temp = addRecursive(root, x);

		if(temp.element == x);
	}
	private BinaryNode<E> addRecursive(BinaryNode<E> current, E value){

		if (current == null) {
			return new BinaryNode<E>(value);
			size++;
		}

		else if(((Comparable<E>)value).compareTo(current.element) < 0){ //går till vänster
			current.left = addRecursive(current.left, value);
		}
		else if(((Comparable<E>)value).compareTo(current.element) > 0){ //går till höger
			current.right = addRecursive(current.right, value);
		}else{
			return current;

		}
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return heightCounter(root);
	}
	private int heightCounter(BinaryNode <E> n){
		if(n == null) {
			return 0;
		}
		return 1 + Math.max(heightCounter(n.left), heightCounter(n.right));
	}

	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size(root);
	}
	private int size(BinaryNode<E> root){
		return size;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		size = 0;
		root = null;

		}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}
	private void print(BinaryNode<E> n){
		if(n != null){
			System.out.println(n.element);
			print(n.left);
			print(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
