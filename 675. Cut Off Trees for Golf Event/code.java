class Solution {
	private static int[] directionX = new int[]{0, 1, 0, -1};
	private static int[] directionY = new int[]{1, 0, -1, 0};

	public int cutOffTree(List<List<Integer>> forest) {
		if(forest == null || forest.size() == 0 || forest.get(0).size() == 0) return 0;
		int row = forest.size();
		int col = forest.get(0).size();
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(forest.get(i).get(j) > 1) heap.add(new int[] {i, j, forest.get(i).get(j)});
			}
		}
		int[] start = new int[2];
		int sum = 0;
		while (!heap.isEmpty()) {
			int[] end = heap.poll();
			int step = minStep(forest, start, end, row, col);
			if (step < 0) return -1;
			sum += step;
			start = end;
		}

		return sum;
	}

	private int minStep(List<List<Integer>> forest, int[] start, int[] end, int row, int col) {
		int step = 0;
		boolean[][] visited = new boolean[row][col];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				int[] curr = queue.poll();
				if(curr[0] == end[0] && curr[1] == end[1]) return step;
				for(int k = 0; k < 4; k++) {
					int next_x = curr[0] + directionX[k];
					int next_y = curr[1] + directionY[k];
					if(next_x < 0 || next_x >= row || next_y < 0 || next_y >= col || 
						forest.get(next_x).get(next_y) == 0 || visited[next_x][next_y]) continue;
					visited[next_x][next_y] = true;
					queue.add(new int[]{next_x, next_y});
				}
			}
			step++;
		}
		return -1;
	}
}