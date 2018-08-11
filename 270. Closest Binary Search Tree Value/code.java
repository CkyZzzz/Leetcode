class Solution {
	//T = O(n) S = O(1)
	private Double diff = null;
	private Integer result = null;
	public int closestValue(TreeNode root, double target) {
		helper(root, target);
		return result;
	}
	private void helper(TreeNode root, double target){
		if(root == null) return;
		helper(root.left, target);
		if(diff == null){
			diff = Math.abs(target - root.val);
			result = root.val;
		}else{
			if(Math.abs(target - root.val) < diff){
				diff = Math.abs(target - root.val);
				result = root.val;
			}
		}
		helper(root.right, target);
	}
}