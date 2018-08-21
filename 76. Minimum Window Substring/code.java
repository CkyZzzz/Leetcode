class Solution {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c: t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
		int count = map.size(), start = 0, end = 0, minLen = Integer.MAX_VALUE;
		String result = "";
		while(end < s.length()){
			char curr = s.charAt(end);
			if(map.containsKey(curr)){
				map.put(curr, map.get(curr) - 1);
				if(map.get(curr) == 0) count--;
			}
			while(start <= end && count == 0){
				char prev = s.charAt(start);
				if(map.containsKey(prev)){
					map.put(prev, map.get(prev) + 1);
					if(map.get(prev) > 0) count++;
					if(count > 0){
						if(end - start + 1 < minLen){
							result = s.substring(start, end + 1);
							minLen = end - start + 1;
						}
					} 
				}
				start++;
			}
			end++;
		}
		return result;
	}
}