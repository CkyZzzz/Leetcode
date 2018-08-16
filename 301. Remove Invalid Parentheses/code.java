class Solution {
	dfs
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		helper(s, 0, 0, result, new char[]{'(', ')'});
		return result;
	}
	private void helper(String s, int start, int end, List<String> result, char[] parentheses){
		int stack = 0;
		for(int i = end; i < s.length(); i++){
			if(s.charAt(i) == parentheses[0]) stack++;
			if(s.charAt(i) == parentheses[1]) stack--;
			if(stack >= 0) continue;
			for(int j = start; j <= i; j++){
				if(s.charAt(j) == parentheses[1] && (j == start || j > start && s.charAt(j - 1) != parentheses[1])){
					helper(s.substring(0, j) + s.substring(j + 1), j, i, result, parentheses);
				}
			}
			return;
		}
		String rvsStr = new StringBuilder(s).reverse().toString();
		if(parentheses[0] == '('){
			helper(rvsStr, 0, 0, result, new char[]{')', '('});
		}else{
			result.add(rvsStr);
		}
	}
	
	//bfs
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		boolean found = false;
		queue.offer(s);
		set.add(s);
		while(!queue.isEmpty()){
			String curr = queue.poll();
			if(isValid(curr)){
				result.add(curr);
				found = true;
			}
			//因为最后所有的结果长度都一样所以可以用这个停止宽搜，避免出现错误解
			if(found) continue;
			for(int i = 0; i < curr.length(); i++){
				if(curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
				String temp = curr.substring(0, i) + curr.substring(i + 1);
				if(!set.contains(temp)){
					queue.offer(temp);
					set.add(temp);
				}
			}
		}
		return result;
	}
	private boolean isValid(String str){
		int stack = 0;
		for(int i = 0; i < str.length(); i++){
			char curr = str.charAt(i);
			if(curr == '(') stack++;
			if(curr == ')') stack--;
			if(stack < 0) return false;
		}
		return stack == 0;
	}
}