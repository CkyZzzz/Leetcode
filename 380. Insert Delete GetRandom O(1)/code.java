class RandomizedSet {
	private List<Integer> list;
	private Map<Integer, Integer> positions;
	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		positions = new HashMap<>();
	}
	
	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	//T = O(1)
	public boolean insert(int val) {
		if(positions.containsKey(val)) return false;
		positions.put(val, list.size());
		list.add(val);
		return true;
	}
	
	/** Removes a value from the set. Returns true if the set contained the specified element. */
	//T = O(1)
	public boolean remove(int val) {
		if(!positions.containsKey(val)) return false;
		int position = positions.get(val);
		if(position < list.size() - 1){
			int lastVal = list.get(list.size() - 1);
			list.set(position, lastVal);
			positions.put(lastVal, position);
		}
		list.remove(list.size() - 1);
		positions.remove(val);
		return true;
	}
	
	/** Get a random element from the set. */
	//T = O(1)
	public int getRandom() {
		java.util.Random random = new java.util.Random();
		return list.get(random.nextInt(list.size()));
	}
}