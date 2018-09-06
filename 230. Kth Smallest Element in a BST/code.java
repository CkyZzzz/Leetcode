//方法一
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
	public int kthSmallest(TreeNode root, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
		helper(root, k, heap);
		if(heap.size() == k + 1) heap.poll();
		return heap.poll();
	}
	private void helper(TreeNode root, int k, PriorityQueue<Integer> heap){
		if(root == null) return;
		if(heap.size() > k) heap.poll();
		heap.offer(root.val);
		helper(root.left, k, heap);
		helper(root.right, k, heap);
	}
}

//方法二
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
		Stack<TreeNode> stack;
		public Iter(TreeNode root){
			stack = new Stack<>();
			helper(root);
		}
		private int next(){
			TreeNode curr = stack.pop();
			if(curr.right != null) helper(curr.right);
			return curr.val;
		}
		private boolean hasNext(){
			return !stack.isEmpty();
		}
		private void helper(TreeNode root){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
		}
	}
	public int kthSmallest(TreeNode root, int k) {
		Iter iter = new Iter(root);
		while(iter.hasNext() && k > 1){
			iter.next();
			k--;
		}
		return iter.next();
	}
}