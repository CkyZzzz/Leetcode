class Solution {
	// T = O(m^2*n^2), The time complexity for BFS/DFS is O(|V|+|E|),
	// In this problem, every vertex has up to 4 edges (left, right, up, down), so |E| ~ 4|V|. 
	// Thus, you have overall O(|V|) = O(mn) for a BFS.
	private int[] directionX = new int[]{0, 1, 0, -1};
	private int[] directionY = new int[]{1, 0, -1, 0};
	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
		int minLen = Integer.MAX_VALUE;
		int buildings = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1) buildings++;
			}
		}
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 0){
					int temp = helper(grid, i, j, buildings);
					if(temp != -1) minLen = Math.min(minLen, temp);
				}
			}
		}
		return minLen == Integer.MAX_VALUE ? -1 : minLen;
	}
	private int helper(int[][] grid, int targetX, int targetY, int buildings){
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int level = 0;
		int path = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{targetX, targetY});
		visited[targetX][targetY] = true;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				int[] curr = queue.poll();
				for(int j = 0; j < 4; j++){
					int[] next = new int[]{curr[0] + directionX[j], curr[1] + directionY[j]};
					if(inBound(grid, next) && !visited[next[0]][next[1]]){
						if(grid[next[0]][next[1]] == 1){
							path += level + 1;
							buildings--;
						}else if(grid[next[0]][next[1]] == 0){
							queue.offer(next);
						}
						visited[next[0]][next[1]] = true;
					}
				}
			}
			level++;
		}
		if(buildings > 0) return -1;
		return path;
	}
	private boolean inBound(int[][] grid, int[] position){
		return position[0] >= 0 && position[0] < grid.length && position[1] >= 0 && position[1] < grid[0].length;
	}
}