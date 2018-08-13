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
	private TreeNode mistake1 = null;
	private TreeNode mistake2 = null;
	private TreeNode prev = null;
	public void recoverTree(TreeNode root) {
		helper(root);
		if(mistake2 != null){
			int temp = mistake1.val;
			mistake1.val = mistake2.val;
			mistake2.val = temp;
		}else{
			//重点考虑俩元素在中序遍历中是相邻的，这种情况只靠helper函数，mistake2会没有值，但我们既然知道俩元素相邻，
			//根据比对prev，我们也能很快找到mistake2对应的值，然后二者值调换一下即可
			prev = null;
			find(root, mistake1);
			int temp = mistake1.val;
			mistake1.val = mistake2.val;
			mistake2.val = temp;
		}
	}
	private void helper(TreeNode root){
		if(root == null) return;
		helper(root.left);
		if(prev != null && root.val < prev.val){
			if(mistake1 == null) mistake1 = prev;
			else mistake2 = root;
		}
		prev = root;
		helper(root.right);
	}
	private void find(TreeNode root, TreeNode target){
		if(root == null) return;
		helper(root.left);
		if(prev == target) mistake2 = root;
		prev = root;
		helper(root.right);
	}
}