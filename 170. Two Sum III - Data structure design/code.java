class TwoSum {
	//这道题是有一个tradeoff的过程，即可以让add的时间复杂度为O(n), 然后find的时间复杂度为O(1)
	//也可以是add的时间复杂度为O(1), 然后find的时间复杂度时O(n)
	//其实里面还有一个小技巧, 就是说list通过使用map后可以大大缩小, 这对于add操作不停的加入重复的值有很大的性能提高
	private List<Integer> list;
	private Map<Integer, Integer> map;
	/** Initialize your data structure here. */
	public TwoSum() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}
	
	/** Add the number to an internal data structure.. */
	public void add(int number) {
		if(map.containsKey(number)){
			map.put(number, map.get(number) + 1);
		}else{
			map.put(number, 1);
			list.add(number);
		}
	}
	
	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for(int num1: list){
			int num2 = value - num1;
			if(num1 == num2 && map.get(num1) >= 2 || num1 != num2 && map.containsKey(num2)) return true;
		}
		return false;
	}
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */