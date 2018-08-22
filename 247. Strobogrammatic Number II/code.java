class Solution {
	private static final String[] first = new String[]{"0", "1", "8", "6", "9"};
	private static final String[] second = new String[]{"0", "1", "8", "9", "6"};
	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<>();
		if(n % 2 == 0){
			helper(n, "", result);
		}else{
			helper(n, "0", result);
			helper(n, "1", result);
			helper(n, "8", result);
		}
		return result;
	}
	private void helper(int n, String path, List<String> result){
		if(path.length() == n){
			//排除以0开头的数字除了0，比如0880，就不能放在path里
			if(path.charAt(0) != '0' && path.length() > 1 || path.length() == 1) result.add(path);
			return;
		}
		for(int i = 0; i < 5; i++){
			helper(n, first[i] + path + second[i], result);
		}
	}
}