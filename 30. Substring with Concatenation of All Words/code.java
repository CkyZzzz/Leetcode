class Solution {
	//minimum window substring 这道题很像，这个方法是比较笨的遍历算法，一块一块查
	//T = O((s.length() - len * words.length) * words.length)
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if(s == null || words == null || words.length == 0) return result;
		int len = words[0].length();
		Map<String, Integer> map = new HashMap<>();
		for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
		for(int i = 0; i <= s.length() - len * words.length; i++){
			Map<String, Integer> copy = new HashMap<>(map);
			for(int j = 0; j < words.length; j++){
				String str = s.substring(i + j * len, i + j * len + len);
				if(copy.containsKey(str)){
					copy.put(str, copy.get(str) - 1);
					if(copy.get(str) == 0) copy.remove(str);
				} else break;
			}
			if(copy.isEmpty()) result.add(i);
		}
		return result;
	}
}