package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

   List<Integer> modeList = new ArrayList();
   
   Integer prevVal = null;
   
   int maxOccuranceSoFar = 0;
   int currentMaxOccurance = 0;
   
   public int[] findMode(TreeNode root) {
	   
	   traverseInOrder(root);

	   int[] modes = new int[modeList.size()];

	   for(int i=0; i < modeList.size(); i++) {
		   modes[i] = modeList.get(i);
	   }

	   return modes;

   }
   
   //perform in-order traversal
   public void traverseInOrder(TreeNode root) {
	   if(root == null) {
		   return;
	   }

	   //traverse left
	   traverseInOrder(root.left);

	   if(prevVal != null && root.val == prevVal) {
		   currentMaxOccurance++;
	   } else {
		   currentMaxOccurance = 1;
	   }

	   if(currentMaxOccurance == maxOccuranceSoFar) {
		   modeList.add(root.val);
	   } else if(currentMaxOccurance > maxOccuranceSoFar) {
		   modeList.clear();
		   maxOccuranceSoFar = currentMaxOccurance;
		   modeList.add(root.val);
	   }


	   prevVal = root.val;

	   //traverse right
	   traverseInOrder(root.right);


   }

	
   
   //test method
   public static void main(String[] args) {
	   TreeNode tree = new TreeNode(2147483647);
	   TreeNode right = new TreeNode(2);
	   TreeNode rightLeft = new TreeNode(2);
	   
	   //attach
	   //right.left = rightLeft;
	   //tree.right = right;
	   
	   //test
	   FindModeInBinarySearchTree bst = new FindModeInBinarySearchTree();
	   int[] result = bst.findMode(tree);
	   
	   for(int i=0; i< result.length; i++) {
		   System.out.println(result[i]);
	   }

	}
	
}
	

/*
 * 
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		val = value;
	}

}


