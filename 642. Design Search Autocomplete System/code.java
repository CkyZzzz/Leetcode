class AutocompleteSystem {
	//Map + Trie + PriorityQueue
	private String userInput = "";
	private Trie root;
	Map<String, Integer> map = new HashMap<>();
	class Entry{
		String sentence;
		int time;
		public Entry(String sentence, int time){
			this.sentence = sentence;
			this.time = time;
		}
	}
	class Trie{
		String word;
		Trie[] children;
		public Trie(){
			word = "";
			children = new Trie[27];
		}
	}
	private void addTrie(String word){
		Trie temp = root;
		for(int i = 0; i < word.length(); i++){
			char curr = word.charAt(i);
			if(temp.children[getPosition(curr)] == null) temp.children[getPosition(curr)] = new Trie();
			temp = temp.children[getPosition(curr)];
		}
		temp.word = word;
	}
	private List<String> searchTrie(String prefix){
		List<String> result = new ArrayList<>();
		Trie temp = root;
		for(int i = 0; i < prefix.length(); i++){
			char curr = prefix.charAt(i);
			if(temp.children[getPosition(curr)] == null) return result;
			temp = temp.children[getPosition(curr)];
		}
		helper(temp, result);
		return result;
	}
	private void helper(Trie node, List<String> result){
		if(node == null) return;
		if(!node.word.equals("")) result.add(node.word);
		for(int i = 0; i < node.children.length; i++){
			helper(node.children[i], result);
		}
	}
	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new Trie();
		for(int i = 0; i < sentences.length; i++){
			map.put(sentences[i], times[i]);
		}
		for(String word: sentences){
			addTrie(word);
		}
	}
	
	public List<String> input(char c) {
		List<String> result = new LinkedList<>();
		if(c == '#'){
			addTrie(userInput);
			map.put(userInput, map.getOrDefault(userInput, 0) + 1);
			userInput = "";
			return result;
		}
		userInput += c;
		List<String> tempList = searchTrie(userInput);
		if(tempList.size() == 0) return result;
		//***important***
		//实际上我们是要做一个min heap出来，所以都要反着写，特别是b.sentence.compareTo(a.sentence),容易忘记
		PriorityQueue<Entry> heap = new PriorityQueue<>((a, b) -> 
								(a.time == b.time ? b.sentence.compareTo(a.sentence) : a.time - b.time));
		for(String temp: tempList){
			heap.offer(new Entry(temp, map.get(temp)));
			if(heap.size() > 3) heap.poll();
		}
		while(!heap.isEmpty()) result.add(0, heap.poll().sentence);
		return result;
	}
	
	private int getPosition(char c) {
		if(c != ' ') return c - 'a';
		else return 26;
	}
}