class Solution {
	// T = O(n^2) S = O(n)
	public int lengthOfLIS(int[] nums) {
		int maxLen = 0;
		if(nums == null || nums.length == 0) return maxLen;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] > nums[j]){
					if(dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}
	
	// T = O(nlogn)
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int[] tails = new int[nums.length];
		tails[0] = nums[0];
		int end = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] < tails[0]){
				tails[0] = nums[i];
			}else if(nums[i] > tails[end]){
				tails[++end] = nums[i];
			}else{
				tails[binarySearch(tails, end, nums[i])] = nums[i];
			}
		}
		return end + 1;
	}
	
	private int binarySearch(int[] tails, int end, int value){
		int start = 0;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(tails[mid] > value){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(tails[start] == value) return start;
		return end;
	}
}