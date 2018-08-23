class Solution {
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int count = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == '1'){
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	private void dfs(char[][] grid, int x, int y){
		final int[] directionX = new int[]{0, 1, 0, -1};
		final int[] directionY = new int[]{1, 0, -1, 0};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		grid[x][y] = '0';
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			for(int i = 0; i < 4; i++){
				int[] next = new int[]{curr[0] + directionX[i], curr[1] + directionY[i]};
				if(inBound(grid, next) && grid[next[0]][next[1]] == '1'){
					grid[next[0]][next[1]] = '0';
					queue.offer(next);
				}
			}
		}
	}
	private boolean inBound(char[][] grid, int[] pos){
		return pos[0] >= 0 && pos[0] < grid.length && pos[1] >= 0 && pos[1] < grid[0].length;
	}
	// private class UnionFind{
	//     private int[] map;
	//     private int count;
	//     public UnionFind(int n){
	//         map = new int[n];
	//         count = n;
	//         for(int i = 0; i < n; i++) map[i] = i;
	//     }
	//     public void union(int a, int b){
	//         int root_a = find(a);
	//         int root_b = find(b);
	//         if(root_a != root_b){
	//             map[root_a] = root_b;
	//             count--;
	//         }
	//     }
	//     public int find(int a){
	//         if(a == map[a]) return a;
	//         return map[a] = find(map[a]);
	//     }
	//     public int getCount(){
	//         return count;
	//     }
	// }
	// public int numIslands(char[][] grid) {
	//     if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
	//     final int[] directionX = new int[]{0, 1, 0, -1};
	//     final int[] directionY = new int[]{1, 0, -1, 0};
	//     int row = grid.length;
	//     int col = grid[0].length;
	//     int count = 0;
	//     UnionFind uf = new UnionFind(row * col);
	//     for(int i = 0; i < row; i++){
	//         for(int j = 0; j < col; j++){
	//             if(grid[i][j] == '0') count++;
	//             if(grid[i][j] == '1'){
	//                 for(int k = 0; k < 4; k++){
	//                     int[] adj = new int[]{i + directionX[k], j + directionY[k]};
	//                     if(inBound(grid, adj) && grid[adj[0]][adj[1]] == '1'){
	//                         uf.union(i * col + j, adj[0] * col + adj[1]);
	//                     }
	//                 }
	//             }
	//         }
	//     }
	//     return uf.getCount() - count;
	// }
	// private boolean inBound(char[][] grid, int[] pos){
	//     return pos[0] >= 0 && pos[0] < grid.length && pos[1] >= 0 && pos[1] < grid[0].length;
	// }
}