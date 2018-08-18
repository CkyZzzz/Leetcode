class RandomizedCollection {
	private List<Integer> list;
	private Map<Integer, Set<Integer>> positions;
	/** Initialize your data structure here. */
	public RandomizedCollection() {
		list = new ArrayList<>();
		positions = new HashMap<>();
	}
	
	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		boolean result = !positions.containsKey(val);
		if(result) positions.put(val, new HashSet<>());
		positions.get(val).add(list.size());
		list.add(val);
		return result;
	}
	
	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	// 考虑三种情况: 1. position == list.size() - 1
	//             2. position != list.size() - 1 但是 val == lastVal 1 2抵消了，做了无用功
	//             3. position != list.size() - 1 && val != lastVal
	public boolean remove(int val) {
		if(!positions.containsKey(val)) return false;
		Set<Integer> temp = positions.get(val);
		int position = temp.iterator().next();
		temp.remove(position); //-----------------------1
		if(temp.isEmpty()) positions.remove(val);
		if(position < list.size() - 1){
			int lastVal = list.get(list.size() - 1);
			list.set(position, lastVal);
			positions.get(lastVal).add(position); //------------------------2
			positions.get(lastVal).remove(list.size() - 1);
		}
		list.remove(list.size() - 1);
		return true;
	}
	
	/** Get a random element from the collection. */
	public int getRandom() {
		java.util.Random random = new java.util.Random();
		return list.get(random.nextInt(list.size()));
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */