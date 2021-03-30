package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLinkedList {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}
		
		//maintain a heap to store values in ascending order
		Queue<ListNode> PQ = new PriorityQueue<>(new IndexedNodeComparator());
		
		//initialize PQ with first element from each list
		for(int index = 0; index < lists.length; index++) {
			ListNode currentNode = lists[index];
			if(currentNode != null) {
				//IndexedNode indexedNode = new IndexedNode(index, currentNode);
				PQ.add(currentNode);
			}
		}
		
		ListNode head = null;
		ListNode nodeToAdd = null;
		while(PQ.size() > 0) {
			ListNode currentLeastNode = PQ.poll();
			if(nodeToAdd == null) {
				nodeToAdd =  currentLeastNode;
				head = nodeToAdd;
			} else {
				nodeToAdd.next = currentLeastNode;
				nodeToAdd = nodeToAdd.next;
			}
			
			//add next element to heap
			if(currentLeastNode != null &&
					currentLeastNode.next != null) {
				ListNode nextListNode = currentLeastNode.next;
				PQ.add(nextListNode);
			}
		}
		
	  return head;
	
	}

	public static void main(String[] args) {
		ListNode[] inputList = new ListNode[3];
		ListNode listNode11 = new ListNode(1);
		ListNode listNode12 = new ListNode(4);
		ListNode listNode13 = new ListNode(5);
		listNode11.next = listNode12;
		listNode12.next = listNode13;
		
		inputList[0] = listNode11;
		
		ListNode listNode21 = new ListNode(1);
		ListNode listNode22 = new ListNode(3);
		ListNode listNode23 = new ListNode(4);
		listNode21.next = listNode22;
		listNode22.next = listNode23;
		
		inputList[1] = listNode21;
		
		ListNode listNode31 = new ListNode(2);
		ListNode listNode32 = new ListNode(6);
		listNode31.next = listNode32;
	    
		inputList[2] = listNode31;
		
		MergeKSortedLinkedList sol = new MergeKSortedLinkedList();
		
		ListNode result = sol.mergeKLists(inputList);
		
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		
	}

}

class IndexedNodeComparator implements Comparator<ListNode>{
	@Override
	public int compare(ListNode n1, ListNode n2) {
		return Integer.compare(n1.val, n2.val);
	}
}

/*
 class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}*/



