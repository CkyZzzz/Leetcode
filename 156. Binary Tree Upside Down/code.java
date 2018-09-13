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
	private TreeNode newRoot = null;
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root == null) return null;
		helper(root);
		return newRoot;
	}
	private void helper(TreeNode root){
		if(root.left == null && root.right == null){
			if(newRoot == null) newRoot = root;
			return;
		}
		if(root.left != null) helper(root.left);
		TreeNode right = root.right;
		root.left.left = right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		if(root.right != null) helper(root.right);
	}
}