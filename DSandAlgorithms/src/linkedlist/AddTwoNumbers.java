package linkedlist;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		//validation
		if(l1 ==null) {return l2;}
		if(l2 ==null) {return l1;}
		
		//create result with dummy node
		ListNode result = new ListNode(0);
		
		ListNode head = result;
		
		int carry = 0;
		while(l1 != null && l2 != null) {
			int sum = l1.val + l2.val+carry;
			carry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			
			result.next = newNode;
			
			//increment lists
			l1 = l1.next;
			l2 = l2.next;
			result = result.next;
		}
		//copy remaining of l1
		while(l1 != null) {
			int sum = l1.val + carry;
			carry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			
			result.next = newNode;
			
			//increment lists
			l1 = l1.next;
			result = result.next;
		}
		while(l2 != null) {
			int sum = l2.val + carry;
			carry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			
			result.next = newNode;
			
			//increment lists
			l2 = l2.next;
			result = result.next;
		}
		//check if carry left
		if(carry >0) {
			ListNode newNode = new ListNode(1);
			result.next = newNode;
		}
		return head.next;
	}

	public static void main(String[] args) {
		// (2 -> 4 -> 3) + (5 -> 6 -> 4)
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(5);
		l4.next = l5;
		l5.next = l6;
		
		AddTwoNumbers a2nums = new AddTwoNumbers();
		
		ListNode result = a2nums.addTwoNumbers(l3, l6);
		
		while(result != null) {
			System.out.println(result.val + "-->");
			result = result.next;
		}
		

	}

}


class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
