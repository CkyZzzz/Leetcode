class Solution {
    //两次dp, 一次不包含第一个房子，即默认第一个房子没被盗，第二次不包含最后一个房子，即最后一个房子没被盗
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums, 1, nums.length - 1), helper(nums, 0, nums.length - 2));
    }
    private int helper(int[] nums, int start, int end) {
		int[] dp = new int[end + 1 - start];
		dp[0] = nums[start];
		if(end - start > 0) dp[1] = Math.max(nums[start], nums[start + 1]);
		for(int i = 2; i < dp.length; i++){
			dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
		}
		return dp[end - start];
	}
}