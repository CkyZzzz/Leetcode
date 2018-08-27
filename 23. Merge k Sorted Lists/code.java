/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//方法一: T = O(nlogk) S = O(1)
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(-1);
		ListNode end = dummy;
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
		for(ListNode curr: lists){
			if(curr == null) continue;
			heap.offer(curr);
		}
		while(!heap.isEmpty()){
			ListNode curr = heap.poll();
			end.next = curr;
			end = end.next;
			curr = curr.next;
			if(curr != null) heap.offer(curr);
		}
		return dummy.next;
	}
	
	//方法二: mergeSort
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		return mergeSort(lists, 0, lists.length - 1);
	}
	private ListNode mergeSort(ListNode[] lists, int startIndex, int endIndex){
		if(startIndex >= endIndex) return lists[startIndex];
		int mid = startIndex + (endIndex - startIndex) / 2;
		ListNode left = mergeSort(lists, startIndex, mid);
		ListNode right = mergeSort(lists, mid + 1, endIndex);
		return merge(left, right);
	}
	private ListNode merge(ListNode left, ListNode right){
		ListNode dummy = new ListNode(-1);
		ListNode end = dummy;
		while(left != null && right != null){
			if(left.val > right.val){
				end.next = right;
				right = right.next;
			}else{
				end.next = left;
				left = left.next;
			}
			end = end.next;
		}
		if(left != null) end.next = left;
		if(right != null) end.next = right;
		return dummy.next;
	}
}