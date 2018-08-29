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
	private static final String SPLITER = ",";
	private static final String NN = "#";
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<String, Integer> map = new HashMap<>();
		List<TreeNode> list = new ArrayList<>();
		helper(root, map, list);
		return list;
	}
	private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> list){
		if(root == null) return NN;
		String left = helper(root.left, map, list);
		String right = helper(root.right, map, list);
		//必须序列化成前序遍历或者后序遍历的格式，中序遍历的格式是错的
		String serialize = left + SPLITER + right + SPLITER + root.val;
		//用map储存这种序列化的格式并计数
		map.put(serialize, map.getOrDefault(serialize, 0) + 1);
		if(map.get(serialize) == 2) list.add(root);
		return serialize;
	}
}