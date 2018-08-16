class Solution {
	// 分成三个步骤
	// 从后往前找到第一个i满足nums[i] < nums[i + 1], break
	// 再从后往前找第一个j满足nums[j] > nums[i], 二者的值进行交换, break
	// 最后在把从nums[i + 1]到nums[nums.length - 1]所有的值颠倒过来
	public void nextPermutation(int[] nums) {
		if(nums.length < 2) return;
		int i = nums.length - 2;
		for(; i >= 0; i--){
			if(nums[i] < nums[i + 1]) break;
		}
		if(i == -1){
			reverse(nums, 0, nums.length - 1);
		}else{
			for(int j = nums.length - 1; j > i; j--){
				if(nums[j] > nums[i]){
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					break;
				}
			}
			reverse(nums, i + 1, nums.length - 1);
		}
	}
	private void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}