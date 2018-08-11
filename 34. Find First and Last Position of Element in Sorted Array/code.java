class Solution {
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) return new int[]{-1, -1};
		int start = 0, end = nums.length - 1;
		// = 包含在 end = mid 这一部分里，所以一般情况下, end是第一个target出现的位置
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] < target) start = mid;
			else end = mid;
		}
		int head = 0, tail = nums.length - 1;
		// = 包含在 head = mid 这一部分里， 所以一般情况下, head是最后一个target出现的位置
		while(head + 1 < tail){
			int mid = head + (tail - head) / 2;
			if(nums[mid] > target) tail = mid;
			else head = mid;
		}
		//处理一些特殊情况比如end不是start是或者head不是tail是
		if(nums[end] != target || nums[head] != target){
			if(nums[start] == target) return new int[]{start, start};
			if(nums[tail] == target) return new int[]{tail, tail};
			return new int[]{-1, -1};
		}
		//最后最重要的是我们要以start和tail来判定起始位置和终止位置，start可以理解为一般是最后一个不是target的index，但是当数组里
		//都是target值时，显然start所对应的值也是target也要包含在内，同理，tail一是对应的第一个不再是target的index
		if(nums[start] != target) start++;
		if(nums[tail] != target) tail--;
		return new int[]{start, tail};
	}
}