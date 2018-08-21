public class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();
	public BSTIterator(TreeNode root) {
		helper(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode curr = stack.pop();
		if(curr.right != null){
			helper(curr.right);
		}
		return curr.val;
	}
	
	private void helper(TreeNode root){
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}
}