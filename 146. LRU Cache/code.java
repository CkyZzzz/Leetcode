class LRUCache {
	private class Node{
		int key;
		int value;
		Node prev;
		Node next;
		public Node(int key, int value){
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
	private int capacity;
	private Map<Integer, Node> map;
	private Node head;
	private Node tail;
	public LRUCache(int capacity) {
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
		this.capacity = capacity;
		this.map = new HashMap<>();
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		Node curr = map.get(key);
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		moveToTail(curr);
		return curr.value;
	}
	
	public void put(int key, int value) {
		if(get(key) != -1){
			Node curr = map.get(key);
			curr.value = value;
			return;
		}
		if(map.size() == capacity){
			Node evit = head.next;
			head.next = head.next.next;
			head.next.prev = head;
			map.remove(evit.key);
		}
		Node insert = new Node(key, value);
		map.put(key, insert);
		moveToTail(insert);
	}
	
	private void moveToTail(Node curr){
		tail.prev.next = curr;
		curr.prev = tail.prev;
		curr.next = tail;
		tail.prev = curr;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */