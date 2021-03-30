package tree;

public class BinaryTreeMaximumPathSum {
	
	int result = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxPathSumFromNode(root);
		return result;
	}
	
	public int maxPathSumFromNode(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftMax = Math.max(maxPathSumFromNode(root.left), 0);
		int rightMax = Math.max(maxPathSumFromNode(root.right), 0);
		
		//if path passes through this node
		int maxWithCurrentNode = root.val + leftMax + rightMax;
		
		//update best seen so far
		result = Math.max(result, maxWithCurrentNode);
		
		//else continue with function of calculating max with atMost one nodee
		return root.val + Math.max(leftMax, rightMax);
        
    }

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum dbt  = new BinaryTreeMaximumPathSum();
		
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
		
		System.out.println(dbt.maxPathSum(root));

	}

}
