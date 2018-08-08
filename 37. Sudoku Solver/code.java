//这一道题的本质其实还是搜索，搜索可以解决一切问题，但是是一个很费时的工作，所以怎么搜索是关键，不管是记忆话还是剪枝或者是按照某个规律来搜索，其目的都是为了
//减少搜索的事件，而这一道题的搜索方法其实是边搜边检验当前节点的合法性
class Solution {
	public void solveSudoku(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return;
		helper(board);
	}
	private boolean helper(char[][] board){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.'){
					for(char k = '1'; k <= '9'; k++){
						if(check(board, i, j, k)){
							board[i][j] = k;
							if(helper(board)) return true;
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		//递归的出口，当所有节点都有值时返回true
		return true;
	}
	//这一部分和前一题完全不同，只是去检查当前节点所在的行和列还有正方形是不是合法的
	private boolean check(char[][] board, int row, int col, char c){
		int m = row / 3 * 3;
		int n = col / 3 * 3;
		for(int i = 0; i < 9; i++){
			if(board[row][i] == c) return false;
			if(board[i][col] == c) return false;
			if(board[m + i / 3][n + i % 3] == c) return false;
		}
		return true;
	}
}