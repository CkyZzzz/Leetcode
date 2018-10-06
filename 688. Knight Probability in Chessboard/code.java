class Solution {
	private static final int[] directionX = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
	private static final int[] directionY = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
	public double knightProbability(int N, int K, int r, int c) {
		double[][] dpCurr = new double[N][N];
		for(double[] row : dpCurr) Arrays.fill(row, 1);
		for(int l = 0; l < K; l++) {
			double[][] dpNext = new double[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < 8; k++) {
						int row = i + directionX[k];
						int col = j + directionY[k];
						if(inBound(row, col, N)) dpNext[i][j] += dpCurr[row][col];
					}
				}
			}
			dpCurr = dpNext;
		}
		return dpCurr[r][c] / Math.pow(8, K); 
	}
	private boolean inBound(int r, int c, int len) {
		return r >= 0 && r < len && c >= 0 && c < len;
	}
}