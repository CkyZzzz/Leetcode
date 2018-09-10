class Solution {
	public List<Integer> findClosestElements(int[] nums, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if(x <= nums[0]){
			for(int i = 0; i < k; i++) result.add(nums[i]);
		}else if(x >= nums[nums.length - 1]){
			for(int i = nums.length - 1; i > nums.length - 1 - k; i--) result.add(nums[i]);
		}else{
			int left = -1, right = -1;
			for(int i = 0; i < nums.length; i++){
				if(nums[i] > x){
					right = i;
					left = i - 1;
					break;
				}
			}
			int i = left, j = right;
			while(i >= 0 && j < nums.length){
				if(x - nums[i] <= nums[j] - x){
					result.add(nums[i]);
					i--;
				}else{
					result.add(nums[j]);
					j++;
				}
				k--;
				if(k == 0) break;
			}
			while(i >= 0 && k > 0){
				result.add(nums[i]);
				i--;
				k--;
			}
			while(j < nums.length && k > 0){
				result.add(nums[j]);
				j++;
				k--;
			}
		}
		Collections.sort(result);
		return result;
	}
}