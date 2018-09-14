/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<>();
	public NestedIterator(List<NestedInteger> nestedList) {
		helper(nestedList);
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	//那判断放在hasNext()里面，这句很关键
	public boolean hasNext() {
		if(stack.isEmpty()) return false;
		NestedInteger curr = stack.pop();
		while(!curr.isInteger()){
			helper(curr.getList());
			if(stack.isEmpty()) return false;
			curr = stack.pop();
		}
		stack.push(curr);
		return true;
	}
	
	private void helper(List<NestedInteger> nestedList){
		for(int i = nestedList.size() - 1; i >= 0; i--){
			stack.push(nestedList.get(i));
		}
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */