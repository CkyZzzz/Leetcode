class MedianFinder {
	//用两个栈实现，前一部分储存在一个最大栈里，后一部分储存在一个最小栈里
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	/** initialize your data structure here. */
	public MedianFinder() {
		maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		minHeap = new PriorityQueue<>((a, b) -> (a - b));
	}
	
	public void addNum(int num) {
		int maxSize = maxHeap.size();
		int minSize = minHeap.size();
		//考虑7种情况，顺便提前说一句，我的做法是把奇数个数据多的那一个放到了第一个栈里
		if(maxSize == 0 && minSize == 0){
			maxHeap.offer(num);
		}else if(maxSize == minSize + 1 && num >= maxHeap.peek()){
			minHeap.offer(num);
		}else if(maxSize == minSize + 1 && num < maxHeap.peek()){
			minHeap.offer(maxHeap.poll());
			maxHeap.offer(num);
		}else if(minSize == maxSize + 1 && num <= minHeap.peek()){
			maxHeap.offer(num);
		}else if(minSize == maxSize + 1 && num > minHeap.peek()){
			maxHeap.offer(minHeap.poll());
			minHeap.offer(num);
		}else if(minSize == maxSize && num <= minHeap.peek()){
			maxHeap.offer(num);
		}else if(minSize == maxSize && num > minHeap.peek()){
			maxHeap.offer(minHeap.poll());
			minHeap.offer(num);
		}
	}
	
	public double findMedian() {
		int maxSize = maxHeap.size();
		int minSize = minHeap.size();
		if(maxSize == minSize){
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		return (double) maxHeap.peek();
	}
	
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */