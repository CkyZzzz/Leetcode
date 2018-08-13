class MyCircularQueue {
	private int[] nums;
	private int start;
	private int end;
	private boolean isFull;
	private boolean isEmpty;
	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		nums = new int[k];
		start = 0;
		end = -1;
		isEmpty = true;
		if(k == 0) isFull = true;
		else isFull = false;
	}
	
	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if(isFull) return false;
		end++;
		if(end == nums.length) end = 0;
		nums[end] = value;
		if(end + 1 == start || end == nums.length - 1 && start == 0) isFull = true;
		isEmpty = false;
		return true;
	}
	
	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if(isEmpty) return false;
		start++;
		if(start == nums.length) start = 0;
		if(end + 1 == start || end == nums.length - 1 && start == 0) isEmpty = true;
		isFull = false;
		return true;
	}
	
	/** Get the front item from the queue. */
	public int Front() {
		if(isEmpty()) return -1;
		return nums[start];
	}
	
	/** Get the last item from the queue. */
	public int Rear() {
		if(isEmpty()) return -1;
		return nums[end];
	}
	
	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return isEmpty;
	}
	
	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return isFull;
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */