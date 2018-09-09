/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> prevStack = new Stack<>();
		Stack<TreeNode> nextStack = new Stack<>();
		initPrevStack(root, prevStack, target);
		initNextStack(root, nextStack, target);
		boolean flag = false;
		if(!prevStack.isEmpty() && !nextStack.isEmpty() && prevStack.peek().val == nextStack.peek().val){
			k++;
			flag = true;
		}
		while(!prevStack.isEmpty() && !nextStack.isEmpty() && k > 0){
			if(target - prevStack.peek().val < nextStack.peek().val - target){
				result.add(getPrevVal(prevStack));
			}else{
				result.add(getNextVal(nextStack));
			}
			k--;
		}
		while(!prevStack.isEmpty() && k > 0){
			result.add(getPrevVal(prevStack));
			k--;
		}
		while(!nextStack.isEmpty() && k > 0){
			result.add(getNextVal(nextStack));
			k--;
		}
		if(flag) result.removeFirst();
		return result;
	}
	private void initPrevStack(TreeNode root, Stack<TreeNode> prevStack, double target){
		while(root != null){
			if(Double.compare(root.val, target) == 0){
				prevStack.push(root);
				break;
			}else if(Double.compare(root.val, target) > 0){
				root = root.left;
			}else{
				prevStack.push(root);
				root = root.right;
			}
		}
	}
	private void initNextStack(TreeNode root, Stack<TreeNode> nextStack, double target){
		while(root != null){
			if(Double.compare(root.val, target) == 0){
				nextStack.push(root);
				break;
			}else if(Double.compare(root.val, target) > 0){
				nextStack.push(root);
				root = root.left;
			}else{
				root = root.right;
			}
		}
	}
	private int getPrevVal(Stack<TreeNode> prevStack){
		TreeNode curr = prevStack.pop();
		int result = curr.val;
		TreeNode temp = curr.left;
		while(temp != null){
			prevStack.push(temp);
			temp = temp.right;
		}
		return result;
	}
	private int getNextVal(Stack<TreeNode> nextStack){
		TreeNode curr = nextStack.pop();
		int result = curr.val;
		TreeNode temp = curr.right;
		while(temp != null){
			nextStack.push(temp);
			temp = temp.left;
		}
		return result;
	}
}