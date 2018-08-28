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
	private class ResultType{
		boolean p_exist;
		boolean q_exist;
		TreeNode node;
		public ResultType(boolean p_exist, boolean q_exist, TreeNode node){
			this.p_exist = p_exist;
			this.q_exist = q_exist;
			this.node = node;
		}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q).node;
	}
	private ResultType helper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return new ResultType(false, false, null);
		ResultType left = helper(root.left, p, q);
		ResultType right = helper(root.right, p, q);
		if(left.p_exist && left.q_exist) return left;
		if(right.p_exist && right.q_exist) return right;
		boolean p_exist = left.p_exist || right.p_exist || root == p;
		boolean q_exist = left.q_exist || right.q_exist || root == q;
		if(p_exist && q_exist) return new ResultType(p_exist, q_exist, root);
		return new ResultType(p_exist, q_exist, null);
	}
}