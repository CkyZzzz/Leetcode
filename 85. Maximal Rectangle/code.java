class Solution {
	//Largest Rectangle in Histogram这道题的follow up，在可以求直方图中最大面积的基础下，找一个矩阵中值为1的区域组成的最大面积
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int result = 0;
		int[] heights = new int[col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] == '0') heights[j] = 0;
				else heights[j]++;
			}
			result = Math.max(result, helper(heights));
		}
		return result;
	}
	private int helper(int[] heights){
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i <= heights.length; i++){
			int height = (i == heights.length ? 0 : heights[i]);
			if(stack.isEmpty() || height >= heights[stack.peek()]){
				stack.push(i);
			}else{
				int temp = stack.pop();
				maxArea = Math.max(maxArea, heights[temp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
				i--;
			}
		}
		return maxArea;
	}
}