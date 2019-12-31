package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class IterativeInOrderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.EMPTY_LIST;
		}
		List<Integer> result = new ArrayList<>();
		// keep a stack to hold nodes in-order
		Stack<TreeNode> stack = new Stack<>();

		TreeNode current = root;

		while (current != null || stack.size() > 0) {

			// add all left nodes to stack
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			// at this point current == null
			// take the last Node from stack
			TreeNode node = stack.pop();
			result.add(node.val);

			// proceed ant iterate same for right node
			current = node.right;

		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		List<Integer> result = inorderTraversal(root);
		result.forEach(System.out::println);

	}
}

 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
