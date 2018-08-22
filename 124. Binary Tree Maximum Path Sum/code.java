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
    //这种解法的关键在于，考虑每种path必须要考虑是否包含当前节点
    private Integer result = null;
	public int maxPathSum(TreeNode root) {
		helper(root);
		return result;
	}
	private int helper(TreeNode root){
		if(root == null) return 0;
		int currMax = root.val;
		//因为currMax最小取0，所以left和right都>=0
		int left = helper(root.left);
		int right = helper(root.right);
		if(left > 0 && right > 0) currMax += Math.max(left, right);
		if(left > 0 && right == 0) currMax += left;
		if(left == 0 && right > 0) currMax += right;
		if(currMax < 0) currMax = 0;
		if(sum == null) sum = root.val + left + right;
		else sum = Math.max(sum, root.val + left + right);
		return currMax;
	}
}