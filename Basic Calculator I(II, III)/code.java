class Solution {
	// public int calculate(String s) {
	//     s = s.replace(" ", "");
	//     int result = 0;
	//     int number = 0;
	//     int sign = 1;
	//     Stack<Integer> stack = new Stack<>();
	//     for(int i = 0; i < s.length(); i++){
	//         char curr = s.charAt(i);
	//         if(Character.isDigit(curr)){
	//             number = number * 10 + (curr - '0');
	//         }else if(curr == '('){
	//             stack.push(result);
	//             stack.push(sign);
	//             result = 0;
	//             sign = 1;
	//         }else if(curr == ')'){
	//             result += number * sign;
	//             result *= stack.pop();
	//             result += stack.pop();
	//             number = 0;
	//             sign = 1;
	//         }else if(curr == '+'){
	//             result += number * sign;
	//             number = 0;
	//             sign = 1;
	//         }else if(curr == '-'){
	//             result += number * sign;
	//             number = 0;
	//             sign = -1;
	//         }
	//     }
	//     if(number > 0) result += sign * number;
	//     return result;
	// }
	private class Operator{
		char operator;
		int level;
		public Operator(char operator, int level){
			this.operator = operator;
			this.level = level;
		}
	}
	public int calculate(String s) {
		s = s.replace(" ", "");
		s += "#";
		int number = 0;
		int parenthesisLevel = 0;
		Stack<Operator> operatorStack = new Stack<>();
		Stack<Integer> operandStack = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			if(Character.isDigit(curr)){
				number = number * 10 + (curr - '0');
			}else if(curr == '('){
				parenthesisLevel++;
			}else if(curr == ')'){
				parenthesisLevel--;
			}else if(curr == '+' || curr == '-' || curr == '#'){
				operandStack.push(number);
				number = 0;
				while(!operatorStack.isEmpty() && operatorStack.peek().level >= parenthesisLevel){
					helper(operatorStack, operandStack);
				}
				if(i < s.length() - 1) operatorStack.push(new Operator(curr, parenthesisLevel));
			}
		}
		while(!operatorStack.isEmpty()) helper(operatorStack, operandStack);
		return operandStack.isEmpty() ? number : operandStack.pop();
	}
	private void helper(Stack<Operator> operatorStack, Stack<Integer> operandStack){
		int second = operandStack.pop();
		int first = operandStack.pop();
		char operator = operatorStack.pop().operator;
		if(operator == '+'){
			operandStack.push(first + second);
		}else{
			operandStack.push(first - second);
		}
	}
}