class Solution {
	// 方法一: heap
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequencies = new HashMap<>();
		for(String word: words) frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
		PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((a, b) -> 
				(a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
		for(Map.Entry<String, Integer> entry: frequencies.entrySet()) heap.offer(entry);
		List<String> result = new ArrayList<>();
		while(!heap.isEmpty() && k > 0){
			Map.Entry<String, Integer> curr = heap.poll();
			result.add(curr.getKey());
			k--;
		}
		return result;
	}
	
	// 方法二: 木桶
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequencies = new HashMap<>();
		for(String word: words) frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
		List[] buckets = new List[words.length + 1];
		for(Map.Entry<String, Integer> entry: frequencies.entrySet()){
			if(buckets[entry.getValue()] == null)  buckets[entry.getValue()] = new ArrayList<>();
			buckets[entry.getValue()].add(entry.getKey());
		}
		List<String> result = new ArrayList<>();
		for(int i = buckets.length - 1; i >= 0 && k > 0; i--){
			if(buckets[i] != null){
				List<String> tempList = buckets[i];
				Collections.sort(tempList);
				for(String str: tempList){
					result.add(str);
					k--;
					if(k == 0) break;
				}
			}
		}
		return result;
	}
	
	// 方法三: O(n) solution using HashMap, BucketSort and Trie
	// 避免字符串按照ascii标准排序O(nlogn)时间复杂度的一个方法就是用trie树遍历
	private class Trietree{
		Trie root = new Trie();
		private class Trie{
			String word;
			Trie[] children;
			public Trie(){
				word = "";
				children = new Trie[26];
			}
		}
		public void add(String word){
			Trie temp = root;
			for(int i = 0; i < word.length(); i++){
				char curr = word.charAt(i);
				if(temp.children[curr - 'a'] == null) temp.children[curr - 'a'] = new Trie();
				temp = temp.children[curr - 'a'];
			}
			temp.word = word;
		}
		public List<String> getWords(){
			List<String> result = new ArrayList<>();
			helper(root, result);
			return result;
		}
		private void helper(Trie root, List<String> result){
			if(root == null) return;
			if(!root.word.equals("")) result.add(root.word);
			for(int i = 0; i < root.children.length; i++){
				helper(root.children[i], result);
			}
		}
	}
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequencies = new HashMap<>();
		for(String word: words) frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
		Trietree[] buckets = new Trietree[words.length + 1];
		for(Map.Entry<String, Integer> entry: frequencies.entrySet()){
			if(buckets[entry.getValue()] == null)  buckets[entry.getValue()] = new Trietree();
			buckets[entry.getValue()].add(entry.getKey());
		}
		List<String> result = new ArrayList<>();
		for(int i = buckets.length - 1; i >= 0 && k > 0; i--){
			if(buckets[i] != null){
				List<String> temp = buckets[i].getWords();
				for(String str: temp){
					result.add(str);
					k--;
					if(k == 0) break;
				}
			}
		}
		return result;
	}
}