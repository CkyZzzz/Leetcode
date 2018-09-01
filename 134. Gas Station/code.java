class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] rest = new int[gas.length];
		for(int i = 0; i < gas.length; i++) rest[i] = gas[i] - cost[i];
		for(int i = 0; i < rest.length; i++){
			if(rest[i] >= 0 && helper(rest, i)) return i;
		}
		return -1;
	}
	private boolean helper(int[] rest, int start){
		int sum = rest[start];
		for(int i = start + 1; i < rest.length; i++){
			sum += rest[i];
			if(sum < 0) return false;
		}
		for(int i = 0; i < start; i++){
			sum += rest[i];
			if(sum < 0) return false;
		}
		return true;
	}
	
	// 首先有一个定理: If car starts at A and can not reach B. Any station between A and B can not
	// reach B.(B is the first station that A can not reach.)
	// If we do have more fuel provided than costed, that means we can always find a start point 
	// around this circle that we could complete the journey with an empty tank. Hence, we check 
	// from the beginning of the array, if we can gain more fuel at the current station, we will 
	// maintain the start point, else, which means we will burn out of oil before reaching to the 
	// next station, we will start over at the next station.
	// T = O(n), S = O(1)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0;
		for(int i = 0; i < gas.length; i++) tank += gas[i] - cost[i];
		if(tank < 0) return -1;
		int start = 0, rest = 0;
		for(int i = 0; i < gas.length; i++){
			if(rest + gas[i] - cost[i] < 0){
				start = i + 1;
				rest = 0;
			}else{
				rest += gas[i] - cost[i];
			}
		}
		return start;
	}
}