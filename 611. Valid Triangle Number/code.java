class Solution {
	public int triangleNumber(int[] nums) {
		// 根据三角形的性质，两边之和大于第三边，我们先对数组排序，然后规定好最大边，最后用相向双指针走一遍就好了，T = O(n)
		int result = 0;
		Arrays.sort(nums);
		for(int end = nums.length - 1; end >= 2; end--){
			int start = 0, mid = end - 1;
			while(start < mid){
				if(nums[start] + nums[mid] > nums[end]){
					result += mid - start;
					mid--;
				}else{
					start++;
				}
			}
		}
		return result;
	}
}