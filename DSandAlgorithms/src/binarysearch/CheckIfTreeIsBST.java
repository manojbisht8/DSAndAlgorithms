package binarysearch;

public class CheckIfTreeIsBST {

	Node root;

	boolean isBST() {
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTHelper(Node node, int min, int max) {

		// base case, empty tree is BST
		if (node == null) {
			return true;
		}

		// check BST condition
		if (node.val < min || node.val > max) {
			return false;
		}

		// recurse of left BST and right BST
		return isBSTHelper(node.left, min, node.val - 1) && isBSTHelper(node.right, node.val + 1, max);
	}

	public static void main(String[] args) {
		CheckIfTreeIsBST tree = new CheckIfTreeIsBST();
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

	}
}

class Node {
	int val;

	Node left, right;

	public Node(int val) {
		this.val = val;
		left = right = null;
	}
	
	public Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
