package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> Q = new LinkedList<TreeNode>() {{offer(root); offer(null);}};
		//Q.add(root);//initialize
		//Q.add(null); //delimiter
		
		int lastNodeVal = 0;
		
		while(!Q.isEmpty()) {
			TreeNode node = Q.poll();
			
			if(node != null) {
				lastNodeVal  = node.val;
				//add elements as usual
				if(node.left != null) {
					Q.add(node.left);
				}
				if(node.right != null) {
					Q.add(node.right);
				}
			} else { //found delimiter, so prev element was last
				result.add(lastNodeVal);
				//shift delimiter
				if(Q.size() > 0) {
					Q.add(null);
				}
			}
		}
		
		
		return result;
		
        
    }

	public static void main(String[] args) {
		BinaryTreeRightSideView dbt  = new BinaryTreeRightSideView();
		
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
