class Solution {
	//T = O(row + col), S = O(1)
	public boolean searchMatrix(int[][] matrix, int target) {
		int[] pos = new int[]{matrix.length - 1, 0};
		while(pos[0] >= 0 && pos[1] < matrix[0].length){
			if(matrix[pos[0]][pos[1]] == target) return true;
			else if(matrix[pos[0]][pos[1]] < target){
				pos[1]++;
			}else{
				pos[0]--;
			}
		}
		return false;
	}
}