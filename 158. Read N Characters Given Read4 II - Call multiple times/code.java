public class Solution extends Reader4 {
	/**
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return    The number of characters read
	 */
	private char[] cache = new char[4];
	private int index = 0;
	private int sum = 0;
	public int read(char[] buf, int n) {
		int count = 0;
		while(count < n){
			//上一次读操作还剩下一些没有用的，这一次刚好继续读出来
			while(count < n && index < sum){
				buf[count++] = cache[index++];
			}
			//如果之前没读完的缓存部分依然够当前读操作的数量，就直接break
			if(count == n) break;
			index = 0;
			sum = read4(cache);
			//继续读的时候发现源文件里的内容已经读完了，可以直接break了
			if(sum == 0) break;
			while(count < n && index < sum){
				buf[count++] = cache[index++];
			}
		}
		return count;
	}
}