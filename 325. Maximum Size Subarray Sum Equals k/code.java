class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		// 从这个-1处可以看出result = i - map.get(sum - k);而不是result = i - map.get(sum - k) + 1;
		map.put(0, -1);
		int sum = 0;
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			if(map.containsKey(sum - k)){
				if(i - map.get(sum - k) + 1 > result) result = i - map.get(sum - k);
			}
			// 这里一定要写!map.containsKey(sum) 因为要求最长的subarray所以如果不同长度的subarray而sum相同，那
			// 就去短的那一个，即前面的
			if(!map.containsKey(sum)) map.put(sum, i);
		}
		return result;      
	}
}