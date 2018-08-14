class Solution {
	//T = O(n) S = O(1) and in place
	public ListNode deleteDuplicates(ListNode head) {
		//特殊情况head=null时,返回null
		if(head == null) return null;
		//head.val - 1是的dummy的值和head的值必不一样
		ListNode dummy = new ListNode(head.val - 1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode start = null;
		while(head != null){
			int count = 0;
			start = head;
			while(head != null && head.val == start.val){
				head = head.next;
				count++;
			}
			//count = 1说明不重复
			if(count == 1){
				prev = start;
			}else{
				prev.next = head;
			}
		}
		return dummy.next;
	}
}