package binarysearch;

/**
 * @see https://leetcode.com/problems/inorder-successor-in-bst/
 * @author mbisht
 *
 */
public class InorderSuccessorBST {
	
	/**
	 * If traget.val >= root.val, then find successor on right side, 
	 * else store parent node while iterate left and left's parent is successor.
	 * @param root
	 * @param p
	 * @return
	 */
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null) {
			return root;
		}
		
		TreeNode previousNode = null;
		TreeNode current = root;
		
		while(current != null) {
			if(p.val >= current.val) {
				current = current.right; //serach on right side
			} else {
				//store previous node
				previousNode = current;
				current = current.left;
			}
			
		}
		
		return previousNode;
        
    }

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t2.left = t1;
		t2.right = t3;
		
		TreeNode successorNode = inorderSuccessor(t2, t1);
		System.out.print(successorNode.val);
		

	}

}
