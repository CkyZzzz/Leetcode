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
	//用打擂台算法后，T - O(n) n个node
	public int[] findFrequentTreeSum(TreeNode root) {
		if(root == null) return new int[0];
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		helper(root, map);
		int maxTime = 0;
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			if(maxTime < entry.getValue()){
				result.clear();
				result.add(entry.getKey());
				maxTime = entry.getValue();
			}else if(maxTime == entry.getValue()){
				result.add(entry.getKey());
			}
		}
		int[] answer = new int[result.size()];
		for(int i = 0; i < result.size(); i++) answer[i] = result.get(i);
		return answer;
	}
	private int helper(TreeNode root, Map<Integer, Integer> map){
		if(root.left == null && root.right == null){
			map.put(root.val, map.getOrDefault(root.val, 0) + 1);
			return root.val;
		}
		int left = 0, right = 0;
		if(root.left != null) left = helper(root.left, map);
		if(root.right != null) right = helper(root.right, map);
		int temp = left + right + root.val;
		map.put(temp, map.getOrDefault(temp, 0) + 1);
		return temp;
	}
}