class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if(nums == null || nums.length == 0) return result;
		int start = nums[0], end = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(end + 1 == nums[i]){
				end++;
			}else{
				add(result, start, end);
				end = nums[i];
				start = nums[i];
			}
		}
		add(result, start, end);
		return result;
	}
	private void add(List<String> result, int start, int end){
		if(start == end){
			result.add(start + "");
		}else{
			result.add(start + "->" + end);
		}
	}
}