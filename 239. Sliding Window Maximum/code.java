class Solution {
	//T = O(n)  所有数进栈和出栈一次
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <= 0) return new int[0];
		int[] result = new int[nums.length - k + 1];
		//维护一个单调递减栈
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < k - 1; i++){
			while(!queue.isEmpty() && nums[i] > queue.peekLast()) queue.pollLast();
			queue.addLast(nums[i]);
		}
		for(int i = k - 1; i < nums.length; i++){
			while(!queue.isEmpty() && nums[i] > queue.peekLast()) queue.pollLast();
			queue.addLast(nums[i]);
			result[i - k + 1] = queue.peekFirst();
			//这个window已经不包含这样一个值时，所以可能成为不包含值的值只有i - k + 1个
			if(queue.peekFirst() == nums[i - k + 1]) queue.pollFirst();
		}
		return result;
	}
}