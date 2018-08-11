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
	//T = O(n) S = O(k)
	private class Entry{
		int val;
		double diff;
		public Entry(int val, double target){
			this.val = val;
			this.diff = Math.abs(val - target);
		}
	}
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		//必须写成Double.compare(b.diff, a.diff), compareTo函数只适用于Double对象，不适用于double基本数据类型
		PriorityQueue<Entry> heap = new PriorityQueue<>((a, b) -> Double.compare(b.diff, a.diff));
		helper(root, target, k, heap);
		if(heap.size() == k + 1) heap.poll();
		List<Integer> result = new ArrayList<>();
		while(!heap.isEmpty()){
			result.add(heap.poll().val);
		}
		return result;
	}
	private void helper(TreeNode root, double target, int k, PriorityQueue<Entry> heap){
		if(root == null) return;
		helper(root.left, target, k, heap);
		heap.offer(new Entry(root.val, target));
		if(heap.size() > k + 1) heap.poll();
		helper(root.right, target, k, heap);
	}
}