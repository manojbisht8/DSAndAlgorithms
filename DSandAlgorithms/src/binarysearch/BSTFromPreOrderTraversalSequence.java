package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BSTFromPreOrderTraversalSequence {
	
	private Integer rootIndex = 0;
	
	public Node BSTFromPreOrderSequence(List<Integer> sequenceList) {
		return BSTFromPreOrderSequenceHelper(sequenceList, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public Node BSTFromPreOrderSequenceHelper(List<Integer> sequenceList, Integer minVal, Integer maxVal) {
		
		if(rootIndex >= sequenceList.size()) {
			return null;
		}
		
		//check out of range conditions
		Integer rootVal = sequenceList.get(rootIndex);
		if(rootVal < minVal || rootVal > maxVal) {
			return null;
		}
		rootIndex++;
		
		Node leftNode = BSTFromPreOrderSequenceHelper(sequenceList, minVal, rootVal);
		Node rightNode = BSTFromPreOrderSequenceHelper(sequenceList, rootVal, maxVal);
		
		return new Node(rootVal, leftNode, rightNode);
		
	}

	public static void main(String[] args) {
		List<Integer> preOrderSeq = new ArrayList<>();
		preOrderSeq.add(8);  //root
		preOrderSeq.add(4);  //left
		preOrderSeq.add(2);  //left.left
		preOrderSeq.add(5);  //left.right
		preOrderSeq.add(10); //right
		preOrderSeq.add(9);  //right.left
		
		Node root = new BSTFromPreOrderTraversalSequence().BSTFromPreOrderSequence(preOrderSeq);
		
		System.out.println("     " + root.val);
		System.out.println(" " + root.left.val);
		System.out.println("             " + root.right.val);
		
   }

}
