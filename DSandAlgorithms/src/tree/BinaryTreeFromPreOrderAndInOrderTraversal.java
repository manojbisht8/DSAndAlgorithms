package tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreOrderAndInOrderTraversal {
	
	//PreOrder provides the root node
	//InOrder provides the left and right Sub trees
	
	//start preorder with 0 
	int pre_idx = 0;
	int[] preOrderList;
	int[] inOrderList;
	Map<Integer, Integer> inOrderIdxMap = new HashMap<>();
	
	public TNode buildTreeHelper(int left_idx, int right_idx) {
		
		//base case
		if(left_idx == right_idx) {
			return null;
		}
		
		//find root
		TNode root = new TNode(preOrderList[pre_idx]);
		int idx = inOrderIdxMap.get(root.val);
	    pre_idx++;
		
		root.left = buildTreeHelper(left_idx, idx);
		root.right = buildTreeHelper(idx+1, right_idx);
		
		return root;
	}
	
	
	
	public TNode buildTree(int[] preorder, int[] inorder) {
		this.preOrderList = preorder;
		this.inOrderList = inorder;
		
		//add index for inorder list
		for(int i=0; i < inorder.length; i++) {
			inOrderIdxMap.put(inorder[i], i);
		}
		
		return buildTreeHelper(0, inorder.length);
     }
	
	

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		BinaryTreeFromPreOrderAndInOrderTraversal bt = new BinaryTreeFromPreOrderAndInOrderTraversal();
		
		System.out.println(bt.buildTree(preorder, inorder).val);

	}

}

class TNode {
  int val;
  TNode left;
  TNode right;
  TNode(int x) { val = x; }
}
