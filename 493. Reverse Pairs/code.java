class Solution {
	//T = O(nlogn)
	public int reversePairs(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	private int helper(int[] nums, int start, int end){
		if(start >= end) return 0;
		int mid = start + (end - start) / 2;
		int left = helper(nums, start, mid);
		int right = helper(nums, mid + 1, end);
		int count = 0;
		//这一步是关键，当左右两边的数组都排序以后，我们可以在O(n)的时间内找到这些跨越两个数组的important reverse pair
		for(int i = start, j = mid + 1; i <= mid && j <= end;){
			if((long) nums[i] > 2 * (long) nums[j]){
				count += mid + 1 - i;
				j++;
			}else i++;
		}
		mergeSort(nums, start, mid, mid + 1, end);
		return left + right + count;
	}
	//merge sort一定要用一个额外数组去储存排序结果在把它复制一遍回去
	private void mergeSort(int[] nums, int lstart, int lend, int rstart, int rend){
		int index = 0;
		int[] temp = new int[rend - lstart + 1];
		int i = lstart;
		int j = rstart;
		while(i <= lend && j <= rend){
			if(nums[i] < nums[j]){
				temp[index++] = nums[i++];
			}else{
				temp[index++] = nums[j++];
			}
		}
		while(i <= lend) temp[index++] = nums[i++];
		while(j <= rend) temp[index++] = nums[j++];
		for(int k = 0; k < temp.length; k++) nums[lstart + k] = temp[k];
	}
}