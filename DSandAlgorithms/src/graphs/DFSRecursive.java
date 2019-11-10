package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSRecursive {
	
	public static void DFS(Node root) {
		
		if(root == null) {
			return;
		}
		
		//Mark node as visited
		root.visited  = true;
		System.out.println(root.val);
		
		if(root.children != null) {
			for(Node child: root.children) {
				if(child != null && !child.visited) {
				DFS(child);
				}
			}
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
		
		DFSRecursive.DFS(n1);

	}

}

class Node{
	int val;
	boolean visited;
	List<Node> children;
	
	
}
