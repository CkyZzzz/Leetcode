class Solution {
	//T = O(n)
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}
	private int quickSelect(int[] nums, int start, int end, int k){
		if(start == end) return nums[start];
		int left = start, right = end;
		int pivot = nums[left + (right - left) / 2];
		while(left <= right){
			//注意nums[left] > pivot 和 nums[right] < pivot 带等号就会stack overflow
			while(left <= right && nums[left] > pivot) left++;
			while(left <= right && nums[right] < pivot) right--;
			if(left <= right){
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}
		if(start + k - 1 <= right) return quickSelect(nums, start, right, k);
		if(start + k - 1 >= left) return quickSelect(nums, left, end, k - (left - start));
		return nums[right + 1];
	}
	
	//minHeap T = O(nlogk)
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int num: nums){
			heap.offer(num);
			if(heap.size() == k + 1) heap.poll();
		}
		return heap.poll();
	}
}