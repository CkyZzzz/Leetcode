class Solution {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for(char task: tasks) map.put(task, map.getOrDefault(task, 0) + 1);
		PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		for(Map.Entry<Character, Integer> entry: map.entrySet()) heap.offer(entry);
		int count = 0;
		while(!heap.isEmpty()){
			int k = n + 1;
			List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
			while(!heap.isEmpty() && k > 0){
				Map.Entry<Character, Integer> entry = heap.poll();
				entry.setValue(entry.getValue() - 1);
				tempList.add(entry);
				k--;
				count++;
			}
			for(Map.Entry<Character, Integer> entry: tempList){
				if(entry.getValue() > 0) heap.offer(entry);
			}
			//这一句非常关键，写在最后而没有写在上一个for循环前边是有原因的，因为for循环之后才能真正意义上判断heap是否为空
			//为空的话后面的idle就不需要填充进去了
			if(heap.size() > 0) count += k;
		}
		return count;
	}
}