class Solution {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for(int num: nums) sum += num;
		if(sum % k != 0) return false;
		sum = sum / k;
		return helper(nums, k, sum, 0, 0, new boolean[nums.length]);
	}
	private boolean helper(int[] nums, int k, int sum, int curr, int startIndex, boolean[] used){
		if(curr > sum) return false;
		if(k == 0) return true;
		if(curr == sum) return helper(nums, k - 1, sum, 0, 0, used);
		for(int i = startIndex; i < nums.length; i++){
			if(used[i]) continue;
			used[i] = true;
			if(helper(nums, k, sum, curr + nums[i], startIndex + 1, used)) return true;
			used[i] = false;
		}
		return false;
	}
}