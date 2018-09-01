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
	private class Iter{
		private Stack<TreeNode> stack = new Stack<>();
		public Iter(TreeNode root){
			helper(root);
		}
		public int next(){
			TreeNode curr = stack.pop();
			if(curr.right != null) helper(curr.right);
			return curr.val;
		}
		public boolean hasNext(){
			return !stack.isEmpty();
		}
		private void helper(TreeNode root){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
		}
	}
	//利用bst的特性，中序遍历是一个sorted list，然后做一个iterator来遍历这个树，就好像遍历一个有序数组，然后再根据set来判断是否有相加等于k的
	public boolean findTarget(TreeNode root, int k) {
		Iter iter = new Iter(root);
		Set<Integer> set = new HashSet<>();
		while(iter.hasNext()){
			int curr = iter.next();
			if(set.contains(k - curr)) return true;
			set.add(curr);
		}
		return false;
	}
}