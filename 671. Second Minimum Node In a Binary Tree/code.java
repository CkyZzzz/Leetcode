/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	//纯遍历一遍整个树
	private int result;
	public int findSecondMinimumValue(TreeNode root) {
		if(root == null) return -1;
		result = root.val;
		helper(root, root.val);
		if(result == root.val) return -1;
		return result;
	}
	private void helper(TreeNode root, int rootVal){
		if(root == null) return;
		if(root.val == rootVal){
			helper(root.left, rootVal);
			helper(root.right, rootVal);
		}else if(root.val < result){
			result = root.val;  
		}else{
			if(result == rootVal) result = root.val;
		}
	}
}