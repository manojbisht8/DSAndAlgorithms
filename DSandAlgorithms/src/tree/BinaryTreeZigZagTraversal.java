package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagTraversal {
	
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if(root == null) {
    		return result;//return early
    	}
    	
    	Queue<TreeNode> nodesQ = new LinkedList<>();
    	LinkedList<Integer> levelValuesQ = new LinkedList<>(); //to hold nodes of each level
    	
    	//initialize nodesQ
    	nodesQ.add(root);
    	//add null as delimiter
    	nodesQ.add(null);
    	
    	boolean isLeftToRight = true;
    	
    	while(!nodesQ.isEmpty()) {
    		TreeNode currentNode = nodesQ.poll();
    		
    		if(currentNode != null) { //same level
    			if(isLeftToRight) {
    				levelValuesQ.addLast(currentNode.val);
    			} else {
    				levelValuesQ.addFirst(currentNode.val);
    			}
    			
    			if(currentNode.left != null) {
    				nodesQ.add(currentNode.left);
    			}
    			if(currentNode.right != null) {
    				nodesQ.add(currentNode.right);
    			}
    			
    		} else { //new level
    			result.add(levelValuesQ);
    			
    			//initialize for new level
    			levelValuesQ = new LinkedList<>();
    			
    			//toggle
    			isLeftToRight = !isLeftToRight;
    			
    			//add delimiter for new level
    			if(nodesQ.size() >0) {
    			nodesQ.add(null);
    			}
    			
    		}
    	}
    	
    return result;
        
    }

	public static void main(String[] args) {
		/*
		 *       0
		 *  1        2
		 *        3     -3
		 *      4   5
		 *   
		 */
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(-3);
		root.right.left.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		
		List<List<Integer>> result = zigzagLevelOrder(root);
		result.forEach(list -> {
			list.forEach(e -> System.out.print(e +"  "));
			System.out.println();
		});

	}

}
