class Solution {
	//分三段: 0.....1,   1.....1,   1.....0
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int start = 0, end = flowerbed.length - 1;
		while(start < flowerbed.length && flowerbed[start] == 0) start++;
		while(end >= 0 && flowerbed[end] == 0) end--;
		if(end < start) return (flowerbed.length + 1) / 2 >= n;
		int former = start / 2;
		int later = (flowerbed.length - end - 1) / 2;
		int mid = start;
		int count = 0;
		while(mid <= end){
			if(flowerbed[mid] == 1){
				System.out.println(mid);
				int temp = mid - start - 3;
				if(temp > 0) count += (mid - start - 2) / 2;
				start = mid;
			}
			mid++;
		}
		System.out.println(former + " " + count + " " + later);
		return count + former + later >= n;
	}
}