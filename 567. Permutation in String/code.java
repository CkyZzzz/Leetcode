//本质是那一系列同向窗口双指针题的变种，注意start <= end 和 map.get(prev) > 0这两个判断句
class Solution {
	public boolean checkInclusion(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s1.length(); i++){
			char curr = s1.charAt(i);
			map.put(curr, map.getOrDefault(curr, 0) + 1);
		}
		int count = map.size();
		int start = 0, end = 0;
		while(end < s2.length()){
			char curr = s2.charAt(end);
			if(map.containsKey(curr)){
				map.put(curr, map.get(curr) - 1);
				if(map.get(curr) == 0) count--;
			}
			while(start <= end && count == 0){
				char prev = s2.charAt(start);
				if(map.containsKey(prev)){
					map.put(prev, map.get(prev) + 1);
					if(map.get(prev) > 0) count++;
					if(count > 0 && end - start + 1 == s1.length()) return true; 
				}
				start++;
			}
			end++;
		}
		return false;
	}
}