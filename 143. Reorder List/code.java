/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public void reorderList(ListNode head) {
		//两个重要的corner case
		if(head == null || head.next == null) return;
		//先用快慢指针找到中心位置，只有两种情况，一种是整个list的长度为偶数，此时slow领导的后面一半和前边一半相等
		//第二种是list的长度为奇数，slow领导的后面一半比前面的一半多一个
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		//tail指针去找第一半的尾巴
		ListNode tail = head;
		while(tail.next != slow) tail = tail.next;
		tail.next = null;
		//翻转第二段
		ListNode second = null;
		while(slow != null){
			ListNode next = slow.next;
			slow.next = second;
			second = slow;
			slow = next;
		}
		//用一个哑巴指针来反复收集第一段和第二段的node
		ListNode dummy = new ListNode(-1);
		ListNode end = dummy;
		int count = 0;
		ListNode first = head;
		while(first != null && second != null){
			if(count % 2 == 0){
				end.next = first;
				first = first.next;
			}else{
				end.next = second;
				second = second.next;
			}
			end = end.next;
			count++;
		}
		if(second != null) end.next = second;
	}
}