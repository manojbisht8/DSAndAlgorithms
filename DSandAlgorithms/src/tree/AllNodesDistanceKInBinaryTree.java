package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @see https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * @author mbisht
 *
 */
public class AllNodesDistanceKInBinaryTree {
	
	
	/*1.	Annotate each node with parent node using DFS. Create a Map for lookup.
	 2.	    Now perform a BFS from target node
     */
	
	//Map to annotate node with Parent node
	Map<TreeNode, TreeNode> parentLookUp = new HashMap<>();
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		
		dfs(root, null);
		
		List<Integer> result = new ArrayList();
		
		//perform BFS
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(target);
		
		Set<TreeNode> seen = new HashSet<>();
		seen.add(target);
		
		int level = 0;
		while(!Q.isEmpty()) {
			int levelElements = Q.size();
			
			for(int i=0; i< levelElements; i++) {
				TreeNode node = Q.poll();
				
				if(node != null) {
					if(level == K) { //if same level as K
						result.add(node.val);
					}
				
					if(!seen.contains(node.left) && node.left != null) {
						Q.add(node.left);
					}
					if(!seen.contains(node.right) && node.right != null) {
						Q.add(node.right);
					}
					if(!seen.contains(parentLookUp.get(node)) && parentLookUp.containsKey(node)) {
						Q.add(parentLookUp.get(node));
					}
				}
			}
			if(level == K) {
				return result;
			}
			level++;
		}
		
		return result;
   }
	
	private void dfs(TreeNode node, TreeNode parent) {
		if(node == null) { //base case
			return;
		}
		parentLookUp.put(node, parent);
		dfs(node.left, node);
		dfs(node.right, node);
		
	}

	public static void main(String[] args) {
		AllNodesDistanceKInBinaryTree dbt  = new AllNodesDistanceKInBinaryTree();
		
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
		
		System.out.println(dbt.distanceK(root, left1, 1));

	}

}
