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
	//这类题和高度或者说深度有关,我们这里定义高度是leaf node的高度为0, 深度是root node的深度为0,
	//在做题时我们要区分到底是要用高度还是用深度, 用高度的题通常是有返回值的, 用深度的题通常是没有返回值然后在参数里记录深度
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result, 0);
		return result;
	}
	private void helper(TreeNode root, List<Integer> result, int level){
		if(root == null) return;
		if(level == result.size()) result.add(root.val);
		else result.set(level, root.val);
		helper(root.left, result, level + 1);
		helper(root.right, result, level + 1);
	}
}