class Solution {
	public boolean search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return false;
		int start = 0, end = nums.length - 1;
		while(start + 1 < end){
			if(nums[start] == nums[end]){
				start++;
				continue;
			}
			int mid = start + (end - start) / 2;
			if(target >= nums[start]){
				if(nums[mid] >= nums[start]){
					if(nums[mid] > target) end = mid;
					else start = mid;
				}else{
					end = mid;
				}
			}else{
				if(nums[mid] >= nums[start]){
					start = mid;
				}else{
					if(nums[mid] > target) end = mid;
					else start = mid;
				}
			}
		}
		if(nums[start] == target) return true;
		if(nums[end] == target) return true;
		return false;
	}
}