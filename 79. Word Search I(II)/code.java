class Solution {
	//T = O(m * n * word.length() * 4)
	private static final int[] directionX = new int[]{0, 1, 0, -1};
	private static final int[] directionY = new int[]{1, 0, -1, 0};
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 || board[0].length == 0) return false;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == word.charAt(0)){
					boolean[][] used = new boolean[board.length][board[0].length];
					used[i][j] = true;
					//这里的三个参数赋值0, i, j是一个同步关系
					if(helper(board, word, 0, i, j, used)) return true;
					used[i][j] = false;
				}
			}
		}
		return false;
	}
	private boolean helper(char[][] board, String word, int index, int x, int y, boolean[][] used){
		//因为是同步关系所以判断句index == word.length() - 1, 这样不会越界
		if(index == word.length() - 1) return true;
		for(int i = 0; i < 4; i++){
			int next_x = x + directionX[i];
			int next_y = y + directionY[i];
			if(inBound(board, next_x, next_y) && !used[next_x][next_y] && word.charAt(index + 1) == board[next_x][next_y]){
				used[next_x][next_y] = true;
				if(helper(board, word, index + 1, next_x, next_y, used)) return true;
				used[next_x][next_y] = false;
			}
		}
		return false;
	}
	private boolean inBound(char[][] board, int x, int y){
		return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
	}
}