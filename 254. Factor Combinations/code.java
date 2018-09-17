class Solution {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(n, 2, new ArrayList<>(), result);
		return result;
	}
	private void helper(int n, int factor, List<Integer> path, List<List<Integer>> result){
		if(n == 1 && path.size() > 1){
			result.add(new ArrayList<>(path));
		}
		for(int i = factor; i <= n; i++){
			if(n % i == 0){
				path.add(i);
				helper(n / i, i, path, result);
				path.remove(path.size() - 1);
			}
		}
	}
}