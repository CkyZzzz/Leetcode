class Solution {
	private static final int[] directionX = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
	private static final int[] directionY = new int[]{1, 0, -1, 0, 1, -1, -1, 1};
	public void gameOfLife(int[][] board) {
		int[][] nextStage = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				nextStage[i][j] = change(board, i, j);
			}
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = nextStage[i][j];
			}
		}
	}
	private int change(int[][] board, int x, int y){
		int neighbors = getCount(board, x, y);
		if(board[x][y] == 1 && neighbors < 2) return 0;
		if(board[x][y] == 1 && (neighbors == 2 || neighbors == 3)) return 1;
		if(board[x][y] == 1 && neighbors > 3) return 0;
		if(board[x][y] == 0 && neighbors == 3) return 1;
		return board[x][y];
	}
	private int getCount(int[][] board, int x, int y){
		int count = 0;
		for(int i = 0; i < 8; i++){
			int[] neighbor = new int[]{x + directionX[i], y + directionY[i]};
			if(inBound(board, neighbor) && board[neighbor[0]][neighbor[1]] == 1) count++;
		}
		return count;
	}
	private boolean inBound(int[][] board, int[] pos){
		return pos[0] >= 0 && pos[0] < board.length && pos[1] >= 0 && pos[1] < board[0].length;
	}
}