class Solution {
	//典型的用bfs来求最短路径，以一个图的思维来想这道题
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
		for(String word: wordList) dict.add(word);
		if(!dict.contains(endWord)) return 0;
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Map<String, Integer> distances = new HashMap<>();
		distances.put(beginWord, 1);
		while(!queue.isEmpty()){
			String curr = queue.poll();
			//tempList其实就是与当前节点相邻的点的集合
			List<String> tempList = helper(curr, dict);
			for(String temp: tempList){
				if(!distances.containsKey(temp)){
					distances.put(temp, distances.get(curr) + 1);
					queue.offer(temp);
				}
			}
		}
		return distances.containsKey(endWord) ? distances.get(endWord) : 0;
	}
	private List<String> helper(String word, Set<String> dict){
		List<String> result = new ArrayList<>();
		for(int i = 0; i < word.length(); i++){
			for(char j = 'a'; j <= 'z'; j++){
				String temp = word.substring(0, i) + j + word.substring(i + 1);
				if(temp.equals(word)) continue;
				if(dict.contains(temp)) result.add(temp);
			}
		}
		return result;
	}
}