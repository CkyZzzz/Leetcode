class Solution {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1;
		//先Long.valueOf()再Math.abs()
		long ldividend = Math.abs(Long.valueOf(dividend));
		long ldivisor = Math.abs(Long.valueOf(divisor));
		if(ldividend < ldivisor || ldividend == 0) return 0;
		long lresult = divide(ldividend, ldivisor);
		if(lresult * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(lresult * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return sign * (int) lresult;
	}
	
	private long divide(long ldividend, long ldivisor) {
		if(ldividend < ldivisor) return 0;
		long sum = ldivisor;
		int count = 1;
		while(sum + sum < ldividend) {
			sum += sum;
			count += count;
		}
		return count + divide(ldividend - sum, ldivisor);
	}
}