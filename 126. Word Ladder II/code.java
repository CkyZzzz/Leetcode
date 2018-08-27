class Solution {
	//这次写这道题，dfs里我是从beginWord开始向endWord搜索
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> ladders = new ArrayList<>();
		Set<String> dict = new HashSet<>();
		for(String word: wordList) dict.add(word);
		if(!dict.contains(endWord)) return ladders;
		Map<String, Integer> distances = new HashMap<>();
		Map<String, List<String>> graph = new HashMap<>();
		graph.put(beginWord, new ArrayList<>());
		for(String word: dict) graph.put(word, new ArrayList<>());
		bfs(beginWord, endWord, dict, distances, graph);
		dfs(beginWord, endWord, distances, graph, ladders, new ArrayList<>());
		return ladders;
	}
	private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> distances, Map<String, List<String>> graph){
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		distances.put(beginWord, 0);
		while(!queue.isEmpty()){
			String curr = queue.poll();
			List<String> tempList = helper(curr, dict);
			graph.put(curr, new ArrayList<>(tempList));
			for(String temp: tempList){
				if(!distances.containsKey(temp)){
					distances.put(temp, distances.get(curr) + 1);
					queue.offer(temp);
				}
			}
		}
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
	private void dfs(String currWord, String endWord, Map<String, Integer> distances, Map<String, List<String>> graph, List<List<String>> ladders, List<String> path){
		if(currWord.equals(endWord)){
			path.add(currWord);
			ladders.add(new ArrayList<>(path));
			path.remove(path.size() - 1);
			return;
		}else{
			for(String nextWord: graph.get(currWord)){
				if(distances.containsKey(nextWord) && distances.get(nextWord) == distances.get(currWord) + 1){
					path.add(currWord);
					dfs(nextWord, endWord, distances, graph, ladders, path);
					path.remove(path.size() - 1);
				}
			}
		}
	}
}