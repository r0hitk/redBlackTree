package redBlackTree;

import redBlackTree.RedBlackTreeNode.color;

public class RedBlackTree<T extends Comparable<T>> {

	private RedBlackTreeNode<T> sentinel;
	private RedBlackTreeNode<T> root;

	public RedBlackTree() {
		sentinel = new RedBlackTreeNode<>(null);
		sentinel.setColor(color.BLACK);
		root = null;
	}

	public void redBlackInsert(RedBlackTreeNode<T> z) {

		RedBlackTreeNode<T> y, x;
		int temp;

		y = sentinel;
		x = this.root;

		System.out.println(x);

		// Getting NullPointerException in the below while loop condition
		if (x != null) {
			while (x.getData() != null) {
				y = x;

				temp = z.getData().compareTo(x.getData());
				if (temp < 0) {
					x = x.getLeftChild();
				} else {
					x = x.getRightChild();
					System.out.println("Right child of X: " + x);
					System.out.println("Sentinel: " + sentinel);
				}
			}
		}
		z.setParent(y);

		if (y.getData() != null) {
			temp = z.getData().compareTo(y.getData());
			if (temp < 0) {
				y.setLeftChild(z);
			} else {
				y.setRightChild(z);
			}
		} else {
			root = z;
		}
		z.setLeftChild(sentinel);
		z.setRightChild(sentinel);
		z.setColor(color.RED);

		redBlackInsertFix(z);
		System.out.println("First node inserted");

	}

	private void redBlackInsertFix(RedBlackTreeNode<T> z) {
		while (z.getParent().getColor() == color.RED) {
			if (z.getParent() == z.getParent().getParent().getLeftChild()) {
				RedBlackTreeNode<T> y;
				y = z.getParent().getParent().getRightChild();
				if (y.getColor() == color.RED) {
					z.getParent().setColor(color.BLACK);
					y.setColor(color.BLACK);
					z.getParent().getParent().setColor(color.RED);
					z = z.getParent().getParent();
				} else if (z == z.getParent().getRightChild()) {
					z = z.getParent();
					leftRotate(z);
				}
				z.getParent().setColor(color.BLACK);
				z.getParent().getParent().setColor(color.RED);
				rightRotate(z.getParent().getParent());
			} else {
				RedBlackTreeNode<T> y;
				y = z.getParent().getParent().getLeftChild();
				if (y.getColor() == color.RED) {
					z.getParent().setColor(color.BLACK);
					y.setColor(color.BLACK);
					z.getParent().getParent().setColor(color.RED);
					z = z.getParent().getParent();
				} else if (z == z.getParent().getLeftChild()) {
					z = z.getParent();
					rightRotate(z);
				}
				z.getParent().setColor(color.BLACK);
				z.getParent().getParent().setColor(color.RED);
				leftRotate(z.getParent().getParent());
			}
		}
		root.setColor(color.BLACK);

	}

	private void rightRotate(RedBlackTreeNode<T> y) {

		RedBlackTreeNode<T> x;
		x = y.getLeftChild();
		y.setLeftChild(x.getRightChild());
		if (x.getRightChild() != sentinel) {
			x.getRightChild().setParent(y);
		}
		x.setParent(y.getParent());
		if (y.getParent() == sentinel) {
			root = x;
		} else if (y == y.getParent().getLeftChild()) {
			y.getParent().setLeftChild(x);
		} else {
			y.getParent().setRightChild(x);
		}
		x.setRightChild(y);
		y.setParent(x);
	}

	private void leftRotate(RedBlackTreeNode<T> x) {

		RedBlackTreeNode<T> y;
		y = x.getRightChild();
		x.setRightChild(y.getLeftChild());
		if (y.getLeftChild() != sentinel) {
			y.getLeftChild().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == sentinel) {
			root = y;
		} else if (x == x.getParent().getLeftChild()) {
			x.getParent().setLeftChild(y);
		} else {
			x.getParent().setRightChild(y);
		}
		y.setLeftChild(x);
		x.setParent(y);
	}

	public void inOrderTraversal(RedBlackTreeNode<T> x) {

		if (x.getData() != sentinel.getData()) {
			inOrderTraversal(x.getLeftChild());
			System.out.println(x.getData());
			inOrderTraversal(x.getRightChild());
		}
	}

	public RedBlackTreeNode<T> getRoot() {
		return root;
	}
}
