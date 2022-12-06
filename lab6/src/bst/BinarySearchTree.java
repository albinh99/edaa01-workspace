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
	public BinarySearchTree() { //implementera comparable
		root = null;
		size = 0;
		comparator =  (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
		
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) { //lambda-uttryck som inparameter
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
		int temp = size;
		root = addRecursive(root, x);
		if(size == temp){
			return false;
		}
		return true;

	}
	private BinaryNode<E> addRecursive(BinaryNode<E> current, E value){
		if (current == null) {
			size++;
			return new BinaryNode<E>(value);
		}
		else if(comparator.compare(value, current.element) < 0){ //går till vänster
			current.left = addRecursive(current.left, value);
		}
		else if(comparator.compare(value, current.element) > 0){ //går till höger
			current.right = addRecursive(current.right, value);
		}else{
			return current;
		}
		return current;
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
			print(n.left);
			System.out.println(n.element);
			print(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> emptyList = new ArrayList<E>();
		toArray(root, emptyList);
		root = buildTree(emptyList,0,emptyList.size()-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if(n != null){
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right,sorted);
		}

	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first > last) {
			return null;
		}
		int mid = first + (last -first)/2; //hämtar index för mittersta elementet
		BinaryNode<E> nod = new BinaryNode<>(sorted.get(mid)); //skapar nod med värdet som finns på index mid

		nod.left = buildTree(sorted, first, mid - 1);
		nod.right = buildTree(sorted, mid + 1, last);
		return nod;
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
