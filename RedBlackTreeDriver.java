package redBlackTree;

public class RedBlackTreeDriver {

	public static void main(String[] args) {
		
		RedBlackTreeNode<Integer> one = new RedBlackTreeNode<>(50);
		RedBlackTreeNode<Integer> two = new RedBlackTreeNode<>(55);
		RedBlackTreeNode<Integer> three = new RedBlackTreeNode<>(48);
		
		RedBlackTree<Integer> rbt = new RedBlackTree<>();
		
		//System.out.println(rbt.getRoot());
		
		rbt.redBlackInsert(one);
		
		System.out.println("ROOT: "+ rbt.getRoot());
		
		rbt.redBlackInsert(two); 
		rbt.redBlackInsert(three);
	
		System.out.println(rbt.getRoot());
		
		rbt.inOrderTraversal(rbt.getRoot());
	}

}
