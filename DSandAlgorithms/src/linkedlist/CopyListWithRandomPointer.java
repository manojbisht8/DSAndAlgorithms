package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @see https://leetcode.com/problems/copy-list-with-random-pointer/
 * @author manojbisht
 *
 */
public class CopyListWithRandomPointer {
	
	private static Map<Node, Node> oldNewMap = new HashMap<>();
	
	/**
	 * Create a oldNew lookup Map
	 * @param head
	 * @return
	 */
	public static Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		
		
		Node oldNode = head;
		
		//create head of new Node
		Node newNode = new Node(oldNode.val);
		oldNewMap.put(oldNode,  newNode);
		
		while(oldNode != null) {
			newNode.next = getNode(oldNode.next);
			newNode.random = getNode(oldNode.random);
			
			//increment old
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		
		return oldNewMap.get(head);
	}
	
	//look in oldNewMap or else return a new Node
	private static Node getNode(Node head) {
		if(head == null) {
			return null;
		}
		if(oldNewMap.containsKey(head)) {
			return oldNewMap.get(head); //get corresponding new Node
		}
		//create new node
		Node newNode = new Node(head.val);
		oldNewMap.put(head, newNode);
		return newNode;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		n1.random = n4;
		n2.random = n1;
		n3.random = n2;
		
		Node newNode = copyRandomList(n1);
		
		Node randomNode = newNode;
		
		while(newNode != null) {
			System.out.print(newNode.val + "->");
			newNode = newNode.next;
		}
		System.out.println();
		
		while(randomNode != null && randomNode.random != null) {
			System.out.print(randomNode.random.val + "->");
			randomNode = randomNode.random;
		}

	}

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
