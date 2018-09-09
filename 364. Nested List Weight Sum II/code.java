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
	// bfs
	public int depthSumInverse(List<NestedInteger> nestedList) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<List<NestedInteger>> queue = new LinkedList<>();
		queue.offer(nestedList);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < size; i++){
				List<NestedInteger> currList = queue.poll();
				for(NestedInteger element: currList){
					if(element.isInteger()){
						temp.add(element.getInteger());
					}else{
						queue.offer(element.getList());
					}
				}
			}
			list.add(0, temp);
		}
		int result = 0;
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).size(); j++){
				result += list.get(i).get(j) * (i + 1);
			}
		}
		return result;
	}
	
	//dfs
	private class ResultType{
		public int depth;
		public int sum;
		private ResultType(int depth, int sum){
			this.depth = depth;
			this.sum = sum;
		}
	}
	public int depthSumInverse(List<NestedInteger> nestedList) {
		ResultType rt = helper(nestedList);
		return rt.sum;
	}
	private ResultType helper(List<NestedInteger> nestedList){
		if(nestedList.size() == 0) return new ResultType(0, 0);
		//当前这一层的下一层的所有NestedInteger
		List<NestedInteger> temp = new ArrayList<>();
		//当前这一层的integer
		List<Integer> curr = new ArrayList<>();
		for(int i = 0; i < nestedList.size(); i++){
			if(nestedList.get(i).isInteger()){
				curr.add(nestedList.get(i).getInteger());
			}else{
				for(int j = 0; j < nestedList.get(i).getList().size(); j++){
					temp.add(nestedList.get(i).getList().get(j));
				}
			}
		}
		ResultType rt = helper(temp);
		int sum = 0;
		int depth = rt.depth + 1;
		for(int i = 0; i < curr.size(); i++){
			sum += depth * curr.get(i);
		}
		return new ResultType(depth, sum + rt.sum);
	}
}