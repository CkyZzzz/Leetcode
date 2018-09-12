class Solution {
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		helper(num, target, "", 0, 0, 0, result);
		return result;
	}
	private void helper(String num, int target, String path, long sum, long lastF, int startIndex, List<String> result){
		if(startIndex == num.length()){
			if(target == sum) result.add(path);
			return;
		}
		for(int i = startIndex; i < num.length(); i++){
			long curr = Long.valueOf(num.substring(startIndex, i + 1));
			if(path.equals("")){
				helper(num, target, path + curr, sum + curr, curr, i + 1, result);
			}else{
				helper(num, target, path + "+" + curr, sum + curr, curr, i + 1, result);
				helper(num, target, path + "-" + curr, sum - curr, -curr, i + 1, result);
				helper(num, target, path + "*" + curr, (sum - lastF) + lastF * curr, lastF * curr, i + 1, result);
			}
			if(curr == 0) break;
		}
	}
}