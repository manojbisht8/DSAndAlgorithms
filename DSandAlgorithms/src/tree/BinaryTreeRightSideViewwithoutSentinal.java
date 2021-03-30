package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideViewwithoutSentinal {
	
	public List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> Q = new LinkedList<TreeNode>() {{offer(root);}};
		
		while(!Q.isEmpty()) {
			int levelSize = Q.size();
			
			System.out.println("Level size: "+levelSize);
			
			//process each level individually
			for(int i=0; i< levelSize; i++) {
				TreeNode node = Q.poll();
			
				if(i == levelSize-1) {
					result.add(node.val);
				}
				
				//add elements as usual
				if(node.left != null) {
					Q.add(node.left);
				}
				if(node.right != null) {
					Q.add(node.right);
				}
			} 
		}
		
		return result;
   }

	public static void main(String[] args) {
		BinaryTreeRightSideViewwithoutSentinal dbt  = new BinaryTreeRightSideViewwithoutSentinal();
		
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
		
		System.out.println(dbt.rightSideView(root));

	}

}
