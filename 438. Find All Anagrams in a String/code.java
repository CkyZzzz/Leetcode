class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < p.length(); i++){
			char curr = p.charAt(i);
			map.put(curr, map.getOrDefault(curr, 0) + 1);
		}
		int count = map.size();
		int start = 0, end = 0;
		while(end < s.length()){
			char curr = s.charAt(end);
			if(map.containsKey(curr)){
				map.put(curr, map.get(curr) - 1);
				if(map.get(curr) == 0) count--;
			}
			while(start <= end && count == 0){
				char prev = s.charAt(start);
				if(map.containsKey(prev)){
					if(end - start + 1 == p.length()) result.add(start);
					map.put(prev, map.get(prev) + 1);
					if(map.get(prev) > 0) count++;
				}
				start++;
			}
			end++;
		}
		return result;
	}
}