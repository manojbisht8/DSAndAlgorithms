package binarysearch;

/**
 * see 
 * @author mbisht
 *
 */
public class RangeSumBST {
	
	int sum = 0;
	
	public int rangeSumBST(TreeNode root, int L, int R) {
		if(root == null) {
			return 0;
		}
		
		//perform in-order traversal
		//only go left if needed
		if(root.left != null && root.val > L) {
			rangeSumBST(root.left, L, R);
		}
		if(root.val >= L && root.val <= R) {
			sum += root.val;
		}
		//only go right if needed
		if(root.right != null && root.val < R) {
			rangeSumBST(root.right, L, R);
		}
		
		return sum;
    }

	public static void main(String[] args) {
		RangeSumBST rsb  = new RangeSumBST();
		
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
		
		System.out.println(rsb.rangeSumBST(root, 7, 15));
		
		

	}

}



/*class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
}*/
