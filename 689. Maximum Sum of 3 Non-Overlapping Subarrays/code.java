class Solution {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] window = new int[nums.length - k + 1];
		int kSum = 0;
		for(int i = 0; i < nums.length; i++){
			kSum += nums[i];
			//从第k个开始，为了保证window的size为k(0 - k-1), 要开始减去前面的数
			if(i >= k) kSum -= nums[i - k];
			//从i = k - 1开始，就可以填数了
			if(i >= k - 1) window[i - k + 1] = kSum;
		}
		int[] leftIndexes = new int[window.length];
		int max = 0;
		for(int i = 0; i < window.length; i++){
			if(window[i] > window[max]) max = i;
			leftIndexes[i] = max;
		}
		int[] rightIndexes = new int[window.length];
		max = window.length - 1;
		for(int i = window.length - 1; i >= 0; i--){
			// ">="很关键。If there are multiple answers, return the lexicographically smallest one.
			if(window[i] >= window[max]) max = i;
			rightIndexes[i] = max;
		}
		int[] result = new int[]{-1, -1, -1};
		for(int i = k; i < window.length - k; i++){
			int left = leftIndexes[i - k], right = rightIndexes[i + k];
			if(result[0] == -1 || window[left] + window[i] + window[right] > window[result[0]] + window[result[1]] + window[result[2]]){
				result[0] = left;
				result[1] = i;
				result[2] = right;
			}
		}
		return result;
	}
}