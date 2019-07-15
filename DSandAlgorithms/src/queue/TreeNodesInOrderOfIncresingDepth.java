package queue;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class TreeNodesInOrderOfIncresingDepth {
	
	public static List<List<Integer>> getNodesInDepthOrder(Node tree) {
		if (tree == null) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<>();

		// Take 2 queues for N and N+1 level. Completely process Nth level.
		// Move forward by assigning N=N+1 queue...

		Deque<Node> currentQ = new ArrayDeque<>();
		currentQ.add(tree);

		while (!currentQ.isEmpty()) {

			// queue holder for next level
			Deque<Node> nextLevelQ = new ArrayDeque<>();
			
			List<Integer> currentNodesVal = new ArrayList<>();

			// process current Level completely
			while (!currentQ.isEmpty()) {

				Node currentNode = currentQ.removeFirst();
				currentNodesVal.add(currentNode.val);

				if (null != currentNode.left) {
					nextLevelQ.add(currentNode.left);
				}
				if (null != currentNode.right) {
					nextLevelQ.add(currentNode.right);
				}

			}
			
			result.add(currentNodesVal);
			
			//assign currentQ to N+1 queue
			currentQ = nextLevelQ;
		}
		
		return result;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	      
	 *       5
      3            7
   2     1      8   
   */
		Node leaf2 = new Node(2, null, null);
		Node leaf1 = new Node(1, null, null);
		Node leaf8 = new Node(8, null, null);
		Node leaf3 = new Node(3, leaf2, leaf1);
		Node leaf7 = new Node(7, leaf8, null);
		Node root = new Node(5, leaf3, leaf7);
		
		List<List<Integer>> result = getNodesInDepthOrder(root);
		result.forEach(level -> {level.forEach(val -> {
									System.out.print(val+ " ");
								});
			System.out.print("\n");
		});
      
	}
	
}

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
