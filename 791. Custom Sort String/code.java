class Solution {
	public String customSortString(String S, String T) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < S.length(); i++){
			char curr = S.charAt(i);
			map.put(curr, 0);
		}
		String part1 = "", part2 = "";
		for(int i = 0; i < T.length(); i++){
			char curr = T.charAt(i);
			if(map.containsKey(curr)) map.put(curr, map.get(curr) + 1);
			else part2 += curr;
		}
		for(int i = 0; i < S.length(); i++){
			char curr = S.charAt(i);
			int len = map.get(curr);
			for(int j = 0; j < len; j++){
				part1 += curr;
			}
		}
		return part1 + part2;
	}
}