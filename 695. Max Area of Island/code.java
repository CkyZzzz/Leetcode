class Solution {
	public int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		if(grid == null || grid.length == 0 || grid[0].length == 0) return result;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					result = Math.max(result, helper(grid, i, j));
				}
			}
		}
		return result;
	}
	private int helper(int[][] grid, int x, int y){
		final int[] directionX = new int[]{0, 1, 0, -1};
		final int[] directionY = new int[]{1, 0, -1, 0};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		grid[x][y] = 0;
		int count = 1;
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			for(int i = 0; i < 4; i++){
				int[] next = new int[]{curr[0] + directionX[i], curr[1] + directionY[i]};
				if(inBound(grid, next) && grid[next[0]][next[1]] == 1){
					count++;
					grid[next[0]][next[1]] = 0;
					queue.offer(next);
				}
			}
		}
		return count;
	}
	private boolean inBound(int[][] grid, int[] position){
		return position[0] >= 0 && position[0] < grid.length && position[1] >= 0 && position[1] < grid[0].length;
	}
}