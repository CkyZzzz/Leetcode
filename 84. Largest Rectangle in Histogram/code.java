class Solution {
	//经典的单调(递增)栈问题，注意栈里储存的是每一个高度对应的index
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		//注意 i <= heights.length，为了让栈里所有的val都弹出来
		for(int i = 0; i <= heights.length; i++){
			int height = (i == heights.length ? 0 : heights[i]);
			if(stack.isEmpty() || height >= heights[stack.peek()]){
				stack.push(i);
			}else{
				int temp = stack.pop();
				//注意栈为空的情况
				maxArea = Math.max(maxArea, heights[temp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
				i--;
			}
		}
		return maxArea;
	}
}