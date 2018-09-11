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
	//从下往上, 以高度来分类
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		helper(root, result);
		return result;
	}
	private int helper(TreeNode root, List<List<Integer>> result){
		if(root == null) return -1;
		int left = helper(root.left, result);
		int right = helper(root.right, result);
		int height = Math.max(left, right) + 1;
		if(height >= result.size()) result.add(new ArrayList<>());
		result.get(height).add(root.val);
		return height;
	}
}