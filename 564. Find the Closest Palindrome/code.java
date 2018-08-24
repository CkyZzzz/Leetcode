class Solution {
	public String nearestPalindromic(String n) {
	    long num = Long.valueOf(n);
	    if (num == 0) return "1";
	    if (num == 11) return "9";
	    if (num <= 10 || Math.log10(num) % 1 == 0) return num - 1 + "";
		long offset = getOffSet(n);
		//这里的三个数必须是从小到大，因为题目说要去smaller one
	    return min(num, palindry(num - offset + ""), palindry(n), palindry(num + offset + ""));
	}

	private String min(long target, long s1, long s2, long s3) {
	    long[] arr = new long[]{s1, s2, s3};
	    long diff = Long.MAX_VALUE;
		Long result = null;
		for(int i = 0; i < 3; i++){
			long temp = Math.abs(arr[i] - target);
			//因为结果不能等于自己，即n本身就是一个palindrome，但是不能拿来作为返回值
			if(temp != 0 && temp < diff){
				diff = temp;
				result = arr[i];
			}
		}
		return result + "";
	}

	private long palindry(String n) {
		//这里必须再做一次求offset，因为加上偏移量后的值很可能进位，之前的offset就不适用了
		long offset = getOffSet(n);
		long temp = Long.valueOf(n) / offset;
		if(n.length() % 2 == 1){
			return Long.valueOf(temp + "" + new StringBuilder(temp / 10 + "").reverse().toString());
		}else{
			return Long.valueOf(temp + "" + new StringBuilder(temp + "").reverse().toString());
		}
	}
	
	private long getOffSet(String n){
		long exp = n.length() - (n.length() - 1) / 2 - 1;
	    long offset = (long) Math.pow(10, exp);
		return offset;
	}
}