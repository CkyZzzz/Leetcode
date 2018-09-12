class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		Stack<String[]> stack = new Stack<>();
		for(String log: logs){
			String[] curr = log.split(":");
			if(curr[1].equals("start")){
				if(stack.isEmpty()){
					stack.push(curr);
					continue;
				}
				String[] prev = stack.pop();
				result[Integer.valueOf(prev[0])] += Integer.valueOf(curr[2]) - Integer.valueOf(prev[2]);
				stack.push(prev);
				stack.push(curr);
			}else{
				String[] prev = stack.pop();
				result[Integer.valueOf(prev[0])] += Integer.valueOf(curr[2]) - Integer.valueOf(prev[2]) + 1;
				if(!stack.isEmpty()){
					stack.peek()[2] = String.valueOf(Integer.valueOf(curr[2]) + 1);
				}
			}
		}
		return result;
	}
}