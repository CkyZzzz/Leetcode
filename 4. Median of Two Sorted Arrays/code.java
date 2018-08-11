class Solution {
	//T = O(log(min(m,n))) S = O(1)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//m一定不能比n大
		int m = nums1.length;
		int n = nums2.length;
		if(m > n){
			int[] temp = nums1; nums1 = nums2; nums2 = temp;
			m = nums1.length; n = nums2.length;
		}
		int start = 0, end = m, halfLen = (m + n + 1) / 2;
		while(start <= end){
			int i = start + (end - start) / 2;
			int j = halfLen - i;
			if(i > 0 && nums1[i - 1] > nums2[j]){
				//我们需要nums1[i - 1] <= nums2[j], 根据int j = halfLen - i; 所以我们要减少i的值
				end = i - 1;
			}else if(i < m && nums1[i] < nums2[j - 1]){
				//我们需要nums1[i] >= nums2[j - 1], 我们要增大i的值
				start = i + 1;
			}else{
				int leftMax = 0;
				if(i == 0){
					leftMax = nums2[j - 1];
				}else if(j == 0){
					leftMax = nums1[i - 1];
				}else{
					leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				//这句提前返回结果必须写上不然"[],[1]"case过不了
				if((m + n) % 2 == 1) return (double) leftMax;
				int rightMin = 0;
				if(i == m){
					rightMin = nums2[j];
				}else if(j == n){
					rightMin = nums1[i];
				}else{
					rightMin = Math.min(nums1[i], nums2[j]);
				}
				return (leftMax + rightMin) / 2.0;
			}
		}
		return 0.0;
	}
}