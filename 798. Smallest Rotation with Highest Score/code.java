class Solution {
	// e.g. [2, 3, 1, 4, 0]
	// 情况1例如第二个A[1] = 3; i(1) < j(start at 3)
	// 向左转时直到3转到数组尾部才开始满足条件
	// 情况2例如第三个A[2] = 1; i(2) >= j(start at 1)
	// 这时候向左转一开始也是可以的，直到1，然后必须向左转直到1到数组尾部才满足条件
	// 我们最后只需要比较那个转动格数上满足条件的数最多，我们就去这个转动格数为结果
	public int bestRotation(int[] A) {
		int[] rotateNum = new int[A.length];
		for(int i = 0; i < A.length; i++){
			int num = A[i];
			for(int j = num; j < A.length; j++){
				//情况1
				if(i < j){
					rotateNum[i + A.length - j]++;
				}else{
				//情况2
					if(i - j >= 0) rotateNum[i - j]++;
					else rotateNum[i + A.length - j]++;
				}
			}
		}
		int result = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < rotateNum.length; i++){
			if(rotateNum[i] > max){
				result = i;
				max = rotateNum[i];
			}
		}
		return result;
	}
}