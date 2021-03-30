package tree;

import binarysearch.RangeSumBST;


public class DiameterOfBinaryTree {
	
	int ans = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		ans = 1;
		if(root == null) {
			return 0;
		}
		diameterHelper(root);
		return (ans-1);
    }
	
	private int diameterHelper(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int L = diameterHelper(node.left);
		int R = diameterHelper(node.right);
		
		ans = Math.max(ans, L+R+1);
		
		return Math.max(L, R) + 1;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree dbt  = new DiameterOfBinaryTree();
		
		TreeNode root = new TreeNode(15);
		TreeNode left = new TreeNode(10);
		TreeNode right = new TreeNode(18);
		
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(5);
		left.left = left1;
		
		TreeNode left11 = new TreeNode(3);
		left1.left = left11;
		
		TreeNode right11 = new TreeNode(7);
		left1.right = right11;
		
		System.out.println(dbt.diameterOfBinaryTree(root));

	}

}
