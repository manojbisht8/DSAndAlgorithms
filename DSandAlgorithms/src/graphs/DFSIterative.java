package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class DFSIterative {
	
	public static void DFS(Node root) {
		Stack<Node> stack = new Stack<>();
		
		//add first node
		stack.add(root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			if(node != null && !node.visited) {
				if(node.children != null) {
					for(Node child: node.children) {
						stack.push(child);
					}
				}
			}
			
			System.out.println(node.val);
			node.visited = true;
		}
		
	}

	public static void main(String[] args) {
		/*       1
		 *  2         4
		 *         9
		 * 
		 */
		Node n1 = new Node();
		n1.val = 1;
		n1.children = new ArrayList();
		
		Node n2 = new Node();
		n2.val = 2;
		
		Node n4 = new Node();
		n4.val = 4;
		
		Node n9 = new Node();
		n9.val = 9;
		
		n4.children = new ArrayList();
		n4.children.add(n9);
		
		n1.children.add(n2);
		n1.children.add(n4);
		
		DFS(n1);

	}

}
