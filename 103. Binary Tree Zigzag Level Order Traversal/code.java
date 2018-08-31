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
	//树的bfs遍历
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> tempList = new ArrayList<>();
			for(int i = 0; i < size; i++){
				TreeNode curr = queue.poll();
				tempList.add(curr.val);
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
			}
			if(result.size() % 2 == 1) Collections.reverse(tempList);
			result.add(tempList);
		}
		return result;
	}
}