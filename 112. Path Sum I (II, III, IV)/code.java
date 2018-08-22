//112. Path Sum
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
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		return helper(root, sum);
	}
	private boolean helper(TreeNode root, int sum){
		if(root == null){
			if(sum == 0) return true;
			return false;
		}
		if(root.left != null && root.right == null) return helper(root.left, sum - root.val);
		if(root.left == null && root.right != null) return helper(root.right, sum - root.val);
		return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
	}
}

//113. Path Sum II
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		helper(root, sum, new ArrayList<>(), result);
		return result;
	}
	private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
		if(root.left == null && root.right == null){
			if(sum == root.val){
				path.add(root.val);
				result.add(new ArrayList<>(path));
				//***遗漏点***
				path.remove(path.size() - 1);
			}
			return;
		}
		path.add(root.val);
		if(root.left != null) helper(root.left, sum - root.val, path, result);
		if(root.right != null) helper(root.right, sum - root.val, path, result);
		path.remove(path.size() - 1);
	}
}

//437. Path Sum III
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
	public int pathSum(TreeNode root, int sum) {
		if(root == null) return 0;
		return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	private int helper(TreeNode root, int sum) {
		if(root == null) return 0;
		//这里写成sum == root.val是有原因的, 如果用root == null是sum是否等于0来判断，因为每个叶子节点都有两个空子树，
		//而此时如果sum == 0, 就是多加一个
		return (sum == root.val ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
	}
}

//666. Path Sum IV
class Solution {
	public int pathSum(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		Map<String, Integer> map = new HashMap<>();
		//有些叶子结点，它的depth可能不是最低，所以在遍历时还要继续遍历更浅的depth的节点
		Set<String> set = new HashSet<>();
		for(int num: nums) map.put(num / 10 + "", num % 10);
		int sum = 0;
		for(int i = nums.length - 1; i >= 0; i--){
			int depth = nums[i] / 100;
			int position = (nums[i] % 100) / 10;
			if(set.contains(depth + "" + position)) continue;
			while(depth > 0){
				sum += map.get(depth + "" + position);
				set.add(depth + "" + position);
				depth -= 1;
				position = (position + 1) / 2;
			}
		}
		return sum;
	}
}