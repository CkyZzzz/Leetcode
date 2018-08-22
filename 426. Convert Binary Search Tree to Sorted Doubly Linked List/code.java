/*
// Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {}

	public Node(int _val,Node _left,Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
};
*/
class Solution {
	private Node prev;
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		Node dummy = new Node(-1, null, null);
		prev = dummy;
		helper(root);
		dummy.right.left = prev;
		prev.right = dummy.right;
		return dummy.right;
	}
	private void helper(Node root){
		if(root == null) return;
		helper(root.left);
		root.left = prev;
		prev.right = root;
		prev = root;
		helper(root.right);
	}
}