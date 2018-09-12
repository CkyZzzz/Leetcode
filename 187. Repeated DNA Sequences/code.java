class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> result = new HashSet<>();
		Set<String> set = new HashSet<>();
		for(int i = 0; i < s.length() - 9; i++){
			String curr = s.substring(i, i + 10);
			if(set.contains(curr)) result.add(curr);
			else set.add(curr);
		}
		return new ArrayList<>(result);
	}
}