class Solution {
	private class OperatorLvl{
		char operator;
		int parenthesesLvl;
		public OperatorLvl(char operator, int parenthesesLvl){
			this.operator = operator;
			this.parenthesesLvl = parenthesesLvl;
		}
	}
	public int calculate(String s) {
		s = s.replace(" ", "");
		s = s + "#";
		int number = 0;
		int parenthesesLvl = 0;
		Stack<OperatorLvl> operatorStack = new Stack<>();
		Stack<Integer> operandStack = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			if(Character.isDigit(curr)){
				number = 10 * number + (curr - '0');
			}else if(curr == '('){
				parenthesesLvl++;
			}else if(curr == ')'){
				parenthesesLvl--;
			}else{
				operandStack.push(number);
				number = 0;
				while(!operatorStack.isEmpty() && (operatorStack.peek().parenthesesLvl > parenthesesLvl ||
												   operatorStack.peek().parenthesesLvl == parenthesesLvl &&
												  getLevel(operatorStack.peek().operator) >= getLevel(curr))){
					helper(operatorStack, operandStack);
				}
				if(i < s.length() - 1) operatorStack.push(new OperatorLvl(curr, parenthesesLvl));
			}
		}
		return operandStack.pop();
	}
	private void helper(Stack<OperatorLvl> operatorStack, Stack<Integer> operandStack){
		int second = operandStack.pop();
		int one = operandStack.pop();
		char operator = operatorStack.pop().operator;
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