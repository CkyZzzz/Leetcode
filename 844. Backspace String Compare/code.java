class Solution {
	public boolean backspaceCompare(String S, String T) {
		return helper(S).equals(helper(T));
	}
	private String helper(String str){
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++){
			char curr = str.charAt(i);
			if(curr == '#' && !stack.isEmpty()) stack.pop();
			else if(curr != '#') stack.push(curr);
		}
		String result = "";
		while(!stack.isEmpty()) result = stack.pop() + result;
		return result;
	}
}