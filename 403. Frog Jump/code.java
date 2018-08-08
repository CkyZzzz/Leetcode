class Solution {
	public boolean canCross(int[] stones) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i = 0; i < stones.length; i++) map.put(i, new HashSet<>());
		map.get(0).add(1);
		for(int i = 0; i < stones.length - 1; i++){
			Set<Integer> units = map.get(i);
			for(int j = i + 1; j < stones.length; j++){
				if(units.contains(stones[j] - stones[i])){
					int currUnits = stones[j] - stones[i];
					map.get(j).add(currUnits - 1);
					map.get(j).add(currUnits);
					map.get(j).add(currUnits + 1);
				}
				
			}
		}
		return !map.get(stones.length - 1).isEmpty();
	}
}