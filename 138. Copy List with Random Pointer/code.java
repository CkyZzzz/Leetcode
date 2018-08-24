/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode cursor = head;
		while(cursor != null){
			map.put(cursor, new RandomListNode(cursor.label));
			cursor = cursor.next;
		}
		cursor = head;
		while(cursor != null){
			map.get(cursor).next = map.get(cursor.next);
			map.get(cursor).random = map.get(cursor.random);
			cursor = cursor.next;
		}
		return map.get(head);
	}
}