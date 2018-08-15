class Solution {
	public int calculate(String s) {
		s = s.replace(" ", "");
		s = s + "#";
		int number = 0;
		Stack<Character> operatorStack = new Stack<>();
		Stack<Integer> operandStack = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			if(Character.isDigit(curr)){
				number = number * 10 + (curr - '0');
			}else{
				operandStack.push(number);
				number = 0;
				while(!operatorStack.isEmpty() && getLevel(operatorStack.peek()) >= getLevel(curr)){
					helper(operatorStack, operandStack);
				}
				if(i < s.length() - 1) operatorStack.push(curr);
			}
		}
		return operandStack.pop();
	}
	private void helper(Stack<Character> operatorStack, Stack<Integer> operandStack){
		int second = operandStack.pop();
		int one = operandStack.pop();
		char operator = operatorStack.pop();
		if(operator == '*'){
			operandStack.push(one * second);
		}else if(operator == '/'){
			operandStack.push(one / second);
		}else if(operator == '+'){
			operandStack.push(one + second);
		}else{
			operandStack.push(one - second);
		}
	}
	private int getLevel(char curr){
		if(curr == '+' || curr == '-'){
			return 1;
		}else if(curr == '*' || curr == '/'){
			return 2;
		}else{
			return 0;
		}
	}
}