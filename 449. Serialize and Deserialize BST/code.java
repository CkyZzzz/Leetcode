/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
	private static final String SPLITER = ",";
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}
	
	private void helper(TreeNode root, StringBuilder sb) {
		if(root == null) return;
		sb.append(root.val + SPLITER);
		helper(root.left, sb);
		helper(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		//***important*** conrner case
		if(data.equals("")) return null;
		String[] preorder = data.split(SPLITER);
		return helper(preorder, 0, preorder.length - 1);
	}
	
	private TreeNode helper(String[] preorder, int startIndex, int endIndex) {
		if(startIndex > endIndex) return null; //主要负责的是left==null的情况
		int value = Integer.valueOf(preorder[startIndex]);
		if(startIndex == endIndex) return new TreeNode(value);
		TreeNode root = new TreeNode(value);
		int position = findPosition(preorder, startIndex, endIndex, value);
		if(position == -1){
			root.left = helper(preorder, startIndex + 1, endIndex);
			root.right = null;
		}else{
			root.left = helper(preorder, startIndex + 1, position - 1);
			root.right = helper(preorder, position, endIndex);
		}
		return root;
	}
	
	private int findPosition(String[] preorder, int startIndex, int endIndex, int value){
		for(int i = startIndex; i <= endIndex; i++){
			if(Integer.valueOf(preorder[i]) > value) return i;
		}
		return -1;
	}
}