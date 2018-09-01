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
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if(root == null) return result;
		result.add(root.val);
		if(root.left != null) leftBoundary(root.left, result);
		if(root.left != null || root.right != null) bottomeBoundary(root, result);
		if(root.right != null){
			List<Integer> temp = new LinkedList<>();
			rightBoundary(root.right, temp);
			Collections.reverse(temp);
			for(Integer num: temp) result.add(num);
		}
		return result;
	}
	private void leftBoundary(TreeNode root, List<Integer> result){
		if(root.left == null && root.right == null) return;
		result.add(root.val);
		if(root.left != null) leftBoundary(root.left, result);
		else leftBoundary(root.right, result);
	}
	private void bottomeBoundary(TreeNode root, List<Integer> result){
		if(root.left == null && root.right == null){
			result.add(root.val);
			return;
		}
		if(root.left != null) bottomeBoundary(root.left, result);
		if(root.right != null) bottomeBoundary(root.right, result);
	}
	private void rightBoundary(TreeNode root, List<Integer> result){
		if(root.left == null && root.right == null) return;
		result.add(root.val);
		if(root.right != null) rightBoundary(root.right, result);
		else rightBoundary(root.left, result);
	}
}