/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode tempA = headA, tempB = headB;
		while(tempA != null){
			lenA++;
			tempA = tempA.next;
		}
		while(tempB != null){
			lenB++;
			tempB = tempB.next;
		}
		tempA = headA;
		tempB = headB;
		if(lenA > lenB){
			int diff = lenA - lenB;
			while(diff > 0){
				tempA = tempA.next;
				diff--;
			}
		}else{
			int diff = lenB - lenA;
			while(diff > 0){
				tempB = tempB.next;
				diff--;
			}
		}
		while(tempA != null){
			if(tempA == tempB) break;
			tempA = tempA.next;
			tempB = tempB.next;
		}
		return tempA;
	}
}