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
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root == null) return result;
		helper(root, result, "");
		return result;
	}
	private void helper(TreeNode root, List<String> list, String path){
		if(root.left == null && root.right == null){
			list.add(path + root.val);
			return;
		}
		if(root.left != null) helper(root.left, list, path + root.val + "->");
		if(root.right != null) helper(root.right, list, path + root.val + "->");
	}
}