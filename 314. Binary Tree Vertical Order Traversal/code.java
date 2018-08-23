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
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		int[] range = new int[2];
		getRange(root, range, 0);
		for(int i = range[0]; i <= range[1]; i++){
			result.add(new ArrayList<>());
		}
		int center = -range[0];
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> colque = new LinkedList<>();
		queue.offer(root);
		colque.offer(center);
		while(!queue.isEmpty()){
			TreeNode curr = queue.poll();
			int col = colque.poll();
			result.get(col).add(curr.val);
			if(curr.left != null){
				queue.offer(curr.left);
				colque.offer(col - 1);
			}
			if(curr.right != null){
				queue.offer(curr.right);
				colque.offer(col + 1);
			}
		}
		return result;
	}
	private void getRange(TreeNode root, int[] range, int value){
		if(root == null) return;
		range[0] = Math.min(range[0], value);
		range[1] = Math.max(range[1], value);
		getRange(root.left, range, value - 1);
		getRange(root.right, range, value + 1);
	}
}