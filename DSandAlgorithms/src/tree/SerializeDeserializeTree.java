package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @see https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
 * @author manojbisht
 *
 */
public class SerializeDeserializeTree {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder resultSb = new StringBuilder();
    	serializeHelper(root, resultSb);
    	return resultSb.toString();
    }
    
    //DFS with PreOrder traversal
    private void serializeHelper(TreeNode root, StringBuilder result) {
    	//base case
    	if(root == null) {
    		result.append("null");
    		result.append(",");
    		return;
    	}
    	
		result.append(root.val);
		result.append(",");
		
		//append left
		serializeHelper(root.left, result);
		serializeHelper(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	List<String> nodeList = new LinkedList<>();
    	nodeList.addAll(Arrays.asList(data.split(",")));
    	return deserializeHelper(nodeList);
        
    }
    
    private TreeNode deserializeHelper(List<String> nodeList) {
    	if(nodeList.get(0).equals("null")) {
    		nodeList.remove(0);
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
    	//remove root
    	nodeList.remove(0);
    	root.left = deserializeHelper(nodeList);
    	root.right = deserializeHelper(nodeList);
    	return root;
    }

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.left = two;
		one.right = five;
		two.left = three;
		two.right = four;
		
		SerializeDeserializeTree sdTree = new SerializeDeserializeTree();
		
		System.out.print(sdTree.serialize(one));
		

	}

}
