class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode dummy = new ListNode(head.val - 1);
		dummy.next = head;
		ListNode start = null;
		while(head != null){
			int count = 0;
			start = head;
			while(head != null && head.val == start.val){
				head = head.next;
				count++;
			}
			if(count != 1){
				start.next = head;
			}
		}
		return dummy.next;
	}
}