class Solution {
	//其实这是一个dp问题，我们定义dp[i]为从0到i这个array中subarray(包含i)能组成的最大值
	//我们以题目中给的case为例[-2,1,-3,4,-1,2,1,-5,4], i = 2时, 有[-3], [1, -3], [-2, 1, -3]
	//i = 3时, 有[(-3), 4], [(1, -3), 4], [(-2, 1, -3), 4] 和 [4], 可以看出()里的时i = 2时的情况
	//我们转换一下变成 ([-3], [1, -3], [-2, 1, -3]) + 4, [4]
	//所以nums[i] + (prev > 0 ? prev : 0)其实就是以上的一种表示方法
	public int maxSubArray(int[] nums) {
		int prev = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			prev = nums[i] + (prev > 0 ? prev : 0);
			result = Math.max(result, prev);
		}
		return result;
	}
	
	//Merge Sort类似题, T = O(nlogn)
	public int maxSubArray(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}
	private int mergeSort(int[] nums, int start, int end){
		if(start >= end) return nums[start];
		int mid = start + (end - start) / 2;
		int left = mergeSort(nums, start, mid - 1);
		int right = mergeSort(nums, mid + 1, end);
		int cross = crossMaxSum(nums, start, mid, end);
		return Math.max(Math.max(left, right), cross);
	}
	private int crossMaxSum(int[] nums, int start, int mid, int end){
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		int leftTemp = 0;
		int rightTemp = 0;
		for(int i = mid - 1; i >= start; i--){
			leftTemp += nums[i];
			leftMax = Math.max(leftMax, leftTemp);
		}
		for(int i = mid + 1; i <= end; i++){
			rightTemp += nums[i];
			rightMax = Math.max(rightMax, rightTemp);
		}
		if(leftMax < 0) leftMax = 0;
		if(rightMax < 0) rightMax = 0;
		return nums[mid] + leftMax + rightMax;
	}
}