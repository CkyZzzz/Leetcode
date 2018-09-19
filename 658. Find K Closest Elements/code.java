class Solution {
	//T = O(Max(k, logn))
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		LinkedList<Integer> result = new LinkedList<>();
		int index = 0;
		if(x <= arr[0]){
			while(k > 0){
				result.add(arr[index++]);
				k--;
			}
			return result;
		}
		index = arr.length - k;
		if(x >= arr[arr.length - 1]){
			while(k > 0){
				result.add(arr[index++]);
				k--;
			}
			return result;
		}
		int start = 0, end = arr.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(arr[mid] < x){
				start = mid;
			}else{
				end = mid;
			}
		}
		while(start >= 0 && end < arr.length && k > 0){
			if(x - arr[start] <= arr[end] - x){
				result.addFirst(arr[start]);
				start--;
				k--;
			}else{
				result.addLast(arr[end]);
				end++;
				k--;
			}
		}
		while(start >= 0 && k > 0){
			result.addFirst(arr[start]);
			start--;
			k--;
		}
		while(end < arr.length && k > 0){
			result.addLast(arr[end]);
			end++;
			k--;
		}
		return result;
	}
}