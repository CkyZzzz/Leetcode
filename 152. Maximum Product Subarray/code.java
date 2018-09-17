class Solution {
	public int maxProduct(int[] nums) {
		int prevMax = nums[0];
		int prevMin = nums[0];
		int currMax = Integer.MIN_VALUE;
		int currMin = Integer.MAX_VALUE;
		int gloMax = nums[0];
		for(int i = 1; i < nums.length; i++){
			currMax = Math.max(Math.max(prevMax * nums[i], prevMin * nums[i]), nums[i]);
			currMin = Math.min(Math.min(prevMax * nums[i], prevMin * nums[i]), nums[i]);
			gloMax = Math.max(gloMax, currMax);
			prevMax = currMax;
			prevMin = currMin;
		}
		return gloMax;
	}
}