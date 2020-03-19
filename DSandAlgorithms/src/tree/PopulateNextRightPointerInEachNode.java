package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointerInEachNode {
	
	//solution-1 using tree level traversal
	public static Node connectWithQ(Node root) {
		if(root == null) {
			return root; //return early
		}
		
		Queue<Node> nodeQ = new LinkedList<>();
		Queue<Node> levelQ = new LinkedList<>();
		
		//initialize
		nodeQ.add(root);
		nodeQ.add(null); //delimiter for level
		
		while(!nodeQ.isEmpty()) {
			Node currentNode = nodeQ.poll();
			
			if(currentNode != null) {
				//add to levelQ
				if(!levelQ.isEmpty()) {
					Node lastLevelNode = levelQ.poll();
					lastLevelNode.next = currentNode;
				}
				levelQ.add(currentNode);
				
				//add to main nodeQ
				if(currentNode.left != null) {
					nodeQ.add(currentNode.left);
				}
				if(currentNode.right != null) {
					nodeQ.add(currentNode.right);
				}
			} else {
				//reinitialize levelQ
				levelQ = new LinkedList<>();
				
				//add delimiter
				if(nodeQ.size() > 0) {
					nodeQ.add(null);
				}
			}
		}
		return root;
		
        
    }
	
	//solution-1 using linked list, using the already established connection
	public static Node connectWithLinkedList(Node root) {
		if(root == null) {
			return root; //return early
		}
		
		Node leftMost = root;
		
		while(leftMost.left != null) {
			
			Node current = leftMost;
			
			while(current != null) {
			
				//establish connection1, with same parent
				current.left.next = current.right;
			
				//establish connection2, with different parents
				if(current.next != null){
					current.right.next = current.next.left;
				}
				
				current = current.next; //move along same level
			
			}
			
			leftMost = leftMost.left; //move to next level
			
			
		}
		
		return root;
		
		
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		n3.right = n7;
		
		Node root = connectWithLinkedList(n1);
		System.out.println(n1.next);
		System.out.println(n2.next.val);
		System.out.println(n3.next);
		System.out.println(n4.next.val);
		System.out.println(n5.next.val);
		System.out.println(n6.next.val);
		System.out.println(n7.next);

	}

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
