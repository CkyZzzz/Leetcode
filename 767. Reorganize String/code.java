class Solution {
	// 类似于task schedule, 贪心的思想
	// 出现这种一样字母不连续出现的字符串的条件是出现最多次数的字符可以被隔绝开, 时间复杂度T = O(nlogk) k = 26 -> T = O(n)
	public String reorganizeString(String s) {
		if(s.length() <= 1) return s;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			map.put(curr, map.getOrDefault(curr, 0) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		for(Map.Entry<Character, Integer> entry: map.entrySet()) heap.offer(entry);
		Map.Entry<Character, Integer> maxFreq = heap.poll();
		String[] slots = new String[maxFreq.getValue()];
		for(int i = 0; i < slots.length; i++) slots[i] = maxFreq.getKey() + "";
		int index = 0;
		while(!heap.isEmpty()){
			Map.Entry<Character, Integer> curr = heap.poll();
			for(int i = 0; i < curr.getValue(); i++){
				slots[index++] += curr.getKey();
				if(index == slots.length) index = 0;
			}
		}
		if(slots[slots.length - 1].length() == 1 && slots[slots.length - 2].length() == 1) return "";
		return String.join("", slots);
	}
}