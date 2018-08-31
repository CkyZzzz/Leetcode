class Solution {
	//记忆化搜索也不行...依旧会超时
	 public int deleteAndEarn(int[] nums) {
	     List<Integer> list = new ArrayList<>();
	     for(int num: nums) list.add(num);
	     Collections.sort(list);
	     Map<String, Integer> map = new HashMap<>();
	     return helper(list, map);
	 }
	 private int helper(List<Integer> curr, Map<String, Integer> map){
	     String str = curr.toString();
	     if(map.containsKey(str)) return map.get(str);
	     if(curr.size() == 0) return 0;
	     int score = 0;
	     for(int i = 0; i < curr.size(); i++){
	         List<Integer> next = new ArrayList<>();
	         for(int j = 0; j < curr.size(); j++){
	             if(curr.get(j) == curr.get(i) + 1 || curr.get(j) == curr.get(i) - 1 || j == i) continue;
	             next.add(curr.get(j));
	         }
	         score = Math.max(score, curr.get(i) + helper(next, map));
	     }
	     map.put(str, score);
	     return score;
	 }
	
	//dp[i]表示前i + 1个buckets可以得到的最好的结果
	//dp[i] = Math.max(dp[i - 2] + buckets[i] * i, dp[i - 1])
	public int deleteAndEarn(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int max = 0;
		for(int num: nums) max = Math.max(max, num);
		int[] buckets = new int[max + 1];
		for(int i = 0; i < nums.length; i++) buckets[nums[i]]++;
		int[] dp = new int[buckets.length];
		dp[0] = 0;
		dp[1] = 1 * buckets[1];
		for(int i = 2; i < buckets.length; i++){
			dp[i] = Math.max(dp[i - 2] + buckets[i] * i, dp[i - 1]);
		}
		return dp[max];
	}
}