class Solution {
	public int firstMissingPositive(int[] nums) {
		//把非正数都统一变成nums.length + 2,这样他们不会在后面一个遍历中是别的位置的数发生变化
		for(int i = 0; i < nums.length; i++){
			if(nums[i] <= 0) nums[i] = nums.length + 2;
		}
		for(int i = 0; i < nums.length; i++){
			int val = Math.abs(nums[i]);
			//首先确保当前的数是在1到nums.length之间的，且这个数是没有发生过改变的，即nums[val - 1] > 0，防止变成负的之后有会变回正数
			if(val - 1 < nums.length && nums[val - 1] > 0) nums[val - 1] = -nums[val - 1];
		}
		//剩下的任务就是遍历整个数组，找到第一个正数，它对应的index + 1就是the smallest missing positive integer
		int index = 0;
		while(index < nums.length){
			if(nums[index] > 0) return index + 1;
			index++;
		}
		return index + 1;
	}
}