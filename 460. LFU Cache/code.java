class LFUCache {
	private int capacity;
	private int minLvl;
	private Map<Integer, Integer> values = new HashMap<>();
	private Map<Integer, Set<Integer>> frequencyLvls = new HashMap<>();
	private Map<Integer, Integer> frequencies = new HashMap<>();
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.minLvl = -1;
	}
	//get() 和 put() 基本遵循一个原则 那就是只要frequencyLvl为空, 在frequencyLvls里就可以把对应的频数删掉了
	//T = O(1)
	public int get(int key) {
		if(!values.containsKey(key)) return -1;
		int currFrequency = frequencies.get(key);
		frequencies.put(key, currFrequency + 1);
		Set<Integer> frequencyLvl = frequencyLvls.get(currFrequency);
		frequencyLvl.remove(key);
		if(frequencyLvl.isEmpty()){
			if(currFrequency == minLvl) minLvl++;
			frequencyLvls.remove(currFrequency);
		}
		if(!frequencyLvls.containsKey(currFrequency + 1)) frequencyLvls.put(currFrequency + 1, new LinkedHashSet<>());
		frequencyLvls.get(currFrequency + 1).add(key);
		return values.get(key);
	}
	
	//T = O(1)
	public void put(int key, int value) {
		//***important corner case***
		if(capacity == 0) return;
		if(get(key) != -1){
			values.put(key, value);
			return;
		}
		if(values.size() == capacity){
			Set<Integer> temp = frequencyLvls.get(minLvl);
			int evit = temp.iterator().next();
			temp.remove(evit);
			if(temp.isEmpty()) frequencyLvls.remove(minLvl);
			values.remove(evit);
			frequencies.remove(evit);
		}
		values.put(key, value);
		frequencies.put(key, 1);
		minLvl = 1;
		if(!frequencyLvls.containsKey(1)) frequencyLvls.put(1, new LinkedHashSet<>());
		frequencyLvls.get(1).add(key);
	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */