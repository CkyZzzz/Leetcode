 class Solution {
     //T = O(logn)
     public double myPow(double x, int n) {
         int flag = 1;
         if(x < 0 && n % 2 == 1) flag = -1;
         x = Math.abs(x);
         if(n < 0) x = 1 / x;
         // x = 2.00000
         // n = -2147483648
         long num = Math.abs((long) n);
         double result = 1;
         while(num > 0){
             //num最后一定会到1，而这个时候rest也一定是1
             long rest = num % 2;
             num = num / 2;
             if(rest == 1){
                 result *= x;
             }
             x *= x;
         }
         return flag * result;
     }
 }

class Solution {
	public double myPow(double x, int n) {
		if(n == 0) return 1.0;
		int flag = 1;
		if(n < 0){
			x = 1 / x;
			n = -(n + 1);
			flag = -1;
		}
		double result = 1.0;
		double temp = x;
		while(n != 0){
			if(n % 2 == 1){
				result *= temp;
                n--;
			}
			temp *= temp;
			n = n / 2;
		}
		return flag == -1 ? result * x : result;
	}
}