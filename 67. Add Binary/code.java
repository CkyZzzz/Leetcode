class Solution {
	public String addBinary(String a, String b) {
		// 核心思想就是要从后往前
		int[] nums = new int[Math.max(a.length(), b.length()) + 1];
		int rest = 0;
		for(int i = 0; i < Math.min(a.length(), b.length()); i++){
			int aNum = a.charAt(a.length() - 1 - i) - '0';
			int bNum = b.charAt(b.length() - 1 - i) - '0';
			int sum = aNum + bNum + rest;
			if(sum == 3){
				nums[nums.length - 1 - i] = 1;
				rest = 1;
			}else if(sum == 2){
				nums[nums.length - 1 - i] = 0;
				rest = 1;
			}else if(sum == 1){
				nums[nums.length - 1 - i] = 1;
				rest = 0;
			}else if(sum == 0){
				nums[nums.length - 1 - i] = 0;
				rest = 0;
			}
		}
		for(int i = Math.min(a.length(), b.length()); i < a.length(); i++){
			int sum = a.charAt(a.length() - 1 - i) - '0' + rest;
			if(sum == 2){
				nums[nums.length - 1 - i] = 0;
				rest = 1;
			}else if(sum == 1){
				nums[nums.length - 1 - i] = 1;
				rest = 0;
			}else{
				nums[nums.length - 1 - i] = 0;
				rest = 0;
			}
		}
		for(int i = Math.min(a.length(), b.length()); i < b.length(); i++){
			int sum = b.charAt(b.length() - 1 - i) - '0' + rest;
			if(sum == 2){
				nums[nums.length - 1 - i] = 0;
				rest = 1;
			}else if(sum == 1){
				nums[nums.length - 1 - i] = 1;
				rest = 0;
			}else{
				nums[nums.length - 1 - i] = 0;
				rest = 0;
			}
		}
		if(rest == 1) nums[0] = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nums.length; i++){
			if(!(nums[i] == 0 && sb.length() == 0)) sb.append(nums[i]);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}