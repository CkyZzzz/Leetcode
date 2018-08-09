class Solution {
	//这题和Multiply Strings很像，都是用一个数组来储存结果，最后记得"0"的情况单独处理
	public String addStrings(String num1, String num2) {
		int[] nums = new int[Math.max(num1.length(), num2.length()) + 1];
		for(int i = 0; i < Math.min(num1.length(), num2.length()); i++){
			int x = num1.charAt(num1.length() - i - 1) - '0';
			int y = num2.charAt(num2.length() - i - 1) - '0';
			int temp = x + y + nums[nums.length - i - 1];
			nums[nums.length - i - 1] = temp % 10;
			nums[nums.length - i - 2] = temp / 10;
		}
		if(num1.length() > num2.length()){
			for(int i = num2.length(); i < num1.length(); i++){
				int x = num1.charAt(num1.length() - i - 1) - '0';
				int temp = x + nums[nums.length - i - 1];
				nums[nums.length - i - 1] = temp % 10;
				nums[nums.length - i - 2] = temp / 10;
			}
		}else if(num1.length() < num2.length()){
			for(int i = num1.length(); i < num2.length(); i++){
				int y = num2.charAt(num2.length() - i - 1) - '0';
				int temp = y + nums[nums.length - i - 1];
				nums[nums.length - i - 1] = temp % 10;
				nums[nums.length - i - 2] = temp / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nums.length; i++){
			if(!(sb.length() == 0 && nums[i] == 0)) sb.append(nums[i]);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}