/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
	public int depthSum(List<NestedInteger> nestedList) {
		int result = 0;
		int depth = 1;
		while(nestedList.size() != 0){
			List<NestedInteger> temp = new ArrayList<>();
			for(int i = 0; i < nestedList.size(); i++){
				NestedInteger curr = nestedList.get(i);
				if(curr.isInteger()){
					result += depth * curr.getInteger();
				}else{
					for(int j = 0; j < curr.getList().size(); j++){
						temp.add(curr.getList().get(j));
					}
				}
			}
			depth++;
			nestedList = temp;
		}
		return result;
	}
	
	public int depthSum(List<NestedInteger> nestedList) {
		int result = 0;
		int depth = 1;
		Queue<List<NestedInteger>> queue = new LinkedList<>();
		queue.offer(nestedList);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				List<NestedInteger> curr = queue.poll();
				for(int j = 0 ; j < curr.size(); j++){
					if(curr.get(j).isInteger()){
						result += curr.get(j).getInteger() * depth;
					}else{
						queue.offer(curr.get(j).getList());
					}
				}
			}
			depth++;
		}
		return result;
	}
}