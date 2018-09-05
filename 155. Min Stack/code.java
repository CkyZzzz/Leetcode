class MinStack {
	private class Node{
		private int val;
		private int min;
		private Node next;
		public Node(int val, int min){
			this.val = val;
			this.min = min;
		}
	}
	private Node root = null;
	/** initialize your data structure here. */
	public MinStack() {
		
	}
	
	public void push(int x) {
		if(root == null){
			root = new Node(x, x);
			return;
		}
		Node newHead = new Node(x, Math.min(x, root.min));
		newHead.next = root;
		root = newHead;
	}
	
	public void pop() {
		root = root.next;
	}
	
	public int top() {
		return root.val;
	}
	
	public int getMin() {
		return root.min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */