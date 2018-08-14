class Solution {
	//206题是这类题的根基
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode before = dummy;
		ListNode start = null;
		ListNode end = null;
		ListNode after = null;
		while(head != null){
			int i = 0;
			while(i < k && head != null){
				if(i == 0) start = head;
				if(i == k - 1) end = head;
				head = head.next;
				i++;
			}
			//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
			if(head == null && i < k) break;
			after = head;
			end.next = null;
			ListNode newHead = reverse(start, null);
			before.next = newHead;
			start.next = after;
			before = start;
		}
		return dummy.next;
	}
	private ListNode reverse(ListNode head, ListNode newHead){
		if(head == null) return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverse(next, head);
	}
}