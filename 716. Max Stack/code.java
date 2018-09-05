class MaxStack {
	private Stack<Integer> stack;
	private Stack<Integer> maxStack;
	/** initialize your data structure here. */
	public MaxStack() {
		stack = new Stack<>();
		maxStack = new Stack<>();
	}
	
	public void push(int x) {
		stack.push(x);
		if(maxStack.isEmpty() || x >= maxStack.peek()) maxStack.push(x);
	}
	
	public int pop() {
		int temp = stack.pop();
		if(!maxStack.isEmpty() && temp == maxStack.peek()) maxStack.pop();
		return temp;
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int peekMax() {
		return maxStack.peek();
	}
	
	//最难的一个地方 就是说当我们从stack中pop直到找到最大值时，我们要记录pop出来的每个值，而这每个值除了那个最大值外，我们都要
	//再原封不动的还回去，这个过程就需要我们再次调用push()方法
	public int popMax() {
		int max = maxStack.pop();
		Stack<Integer> temp = new Stack<>();
		while(max != stack.peek()) temp.push(stack.pop());
		stack.pop();
		while(!temp.isEmpty()) push(temp.pop());
		return max;
	}
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */