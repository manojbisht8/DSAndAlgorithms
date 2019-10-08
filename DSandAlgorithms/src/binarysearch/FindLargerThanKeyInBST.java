package binarysearch;

public class FindLargerThanKeyInBST {
	
	Node currentLargestNode;
	
	Integer findLargerThanKeyInBST(Node root, int key) {
		
		findLargerThanKeyInBSTHelper(root, key);
		return currentLargestNode.val;
		
	}
	
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	void findLargerThanKeyInBSTHelper(Node root, int key) {

		if(root != null) {
			
			if(root.val > key) {
				currentLargestNode = root;
				findLargerThanKeyInBSTHelper(root.left, key); //find on left side
			} else {
				findLargerThanKeyInBSTHelper(root.right, key);
			}
			
		}

	}

	public static void main(String[] args) {
		FindLargerThanKeyInBST tree = new FindLargerThanKeyInBST();
		/*       4
		    2         5
		 1     3  
		*/ 
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		System.out.println("Next largest: " + tree.findLargerThanKeyInBST(root, 1));

	}

}


