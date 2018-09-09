class WordDistance {
	private Map<String, List<Integer>> map;
	public WordDistance(String[] words) {
		map = new HashMap<>();
		for(int i = 0; i < words.length; i++){
			if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
			map.get(words[i]).add(i);
		}
	}
	
	public int shortest(String word1, String word2) {
		List<Integer> indexes1 = map.get(word1);
		List<Integer> indexes2 = map.get(word2);
		int result = Integer.MAX_VALUE;
		//两个有序列表之间比较，找出离得最近的两个元素，每个元素在一个列表里，时间复杂度简化成O(n)
		for(int i = 0, j = 0; i < indexes1.size() && j < indexes2.size(); ) {
			int index1 = indexes1.get(i), index2 = indexes2.get(j);
			if(index1 < index2) {
				result = Math.min(result, index2 - index1);
				i++;
			} else {
				result = Math.min(result, index1 - index2);
				j++;
			}
		}
		return result;
	}
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */