package redBlackTree;

public class RedBlackTreeNode<T extends Comparable<T>> {

	enum color{
		RED,
		BLACK
	}
	
	private T data;
	private color color;
	private RedBlackTreeNode<T> leftChild;
	private RedBlackTreeNode<T> rightChild;
	private RedBlackTreeNode<T> parent;
	
	
	public RedBlackTreeNode(T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
		parent = null;
		color = null;
	}
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public color getColor() {
		return color;
	}
	public void setColor(color color) {
		this.color = color;
	}
	public RedBlackTreeNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(RedBlackTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public RedBlackTreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(RedBlackTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	public RedBlackTreeNode<T> getParent() {
		return parent;
	}
	public void setParent(RedBlackTreeNode<T> parent) {
		this.parent = parent;
	}
	
	
}
