class Solution {
	public int mySqrt(int x) {
		if(x == 0) return 0;
		int result = 1;
		while(result <= x / result) result++;
		return result - 1;
	}
}