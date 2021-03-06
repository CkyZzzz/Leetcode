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
	private int diameter = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return diameter;
	}
	private int helper(TreeNode root){
		if(root == null) return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}
}