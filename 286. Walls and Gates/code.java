class Solution {
	public void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
		int row = rooms.length;
		int col = rooms[0].length;
		final int[] directionX = new int[]{0, 1, 0, -1};
		final int[] directionY = new int[]{1, 0, -1, 0};
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(rooms[i][j] == 0){
					queue.offer(new int[]{i, j});
				}
			}
		}
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			for(int i = 0; i < 4; i++){
				int[] next = new int[]{curr[0] + directionX[i], curr[1] + directionY[i]};
				if(inBound(row, col, next) && rooms[next[0]][next[1]] == Integer.MAX_VALUE){
					rooms[next[0]][next[1]] = rooms[curr[0]][curr[1]] + 1;
					queue.offer(next);
				}
			}
		}
	}
	private boolean inBound(int row, int col, int[] pos){
		return pos[0] >= 0 && pos[0] < row && pos[1] >= 0 && pos[1] < col;
	}
}