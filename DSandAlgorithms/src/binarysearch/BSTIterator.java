package binarysearch;

import java.util.Stack;

/**
 * @see https://leetcode.com/problems/binary-search-tree-iterator/
 * @author mbisht
 *
 */
public class BSTIterator {
	
	Stack<TreeNode> stack = new Stack<>();
	
	public BSTIterator(TreeNode root) {
		pushAllLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode currentMinimum = stack.pop();
    	
    	//maintain next smallest as top of stack
    	 if(currentMinimum.right != null) {
    		 pushAllLeft(currentMinimum.right);
    	 } 
    	 return currentMinimum.val;
    }
    
    private void pushAllLeft(TreeNode root) {
    	while(root != null) {
    		stack.push(root);
    		root = root.left;
    	}
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
