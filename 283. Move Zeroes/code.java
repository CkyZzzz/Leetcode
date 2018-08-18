class Solution {
	// T = O(n) S = O(1)
	public void moveZeroes(int[] nums) {
		int ptr = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0 && nums[ptr] == 0){
				int temp = nums[i];
				nums[i] = nums[ptr];
				nums[ptr] = temp;
			}
			if(nums[ptr] != 0) ptr++;
		}
	}
	
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int index = 0;
		for(int num: nums){
			if(num != 0) nums[index++] = num;
		}
		for(int i = index; i < nums.length; i++){
			nums[i] = 0;
		}
	}
}