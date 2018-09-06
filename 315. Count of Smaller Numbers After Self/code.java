class Solution {
	// T = O(nlogn) 其实就是在merge sort的过程中把这个找Smaller Numbers After Self的任务做完了
	// mergesort 其实本质可以看成一个二叉树结构，而且一般是后序遍历的二叉树
	private int[] temp;
	public List<Integer> countSmaller(int[] nums) {
		temp = new int[nums.length];
		helper(nums, 0, nums.length - 1);
		List<Integer> result = new ArrayList<>();
		for(int num: temp) result.add(num);
		return result;
	}
	private void helper(int[] nums, int start, int end){
		if(start >= end) return;
		//这里必须是LinkedList, 因为可能有几个下标对应的值是一样的
		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		int mid = start + (end - start) / 2;
		for(int i = start; i <= mid; i++){
			if(!map.containsKey(nums[i])) map.put(nums[i], new LinkedList<>());
			map.get(nums[i]).add(i);
		}
		helper(nums, start, mid);
		helper(nums, mid + 1, end);        
		int i = start, j = mid + 1;
		while(i <= mid && j <= end){
			if(nums[i] > nums[j]) j++;
			else{
				temp[map.get(nums[i]).removeFirst()] += j - mid - 1;
				i++;
			}
		}
		while(i <= mid){
			temp[map.get(nums[i]).removeFirst()] += j - mid - 1;
			i++;
		}
		mergeSort(nums, start, mid, mid + 1, end);
		return;
	}
	//merge sort一定要用一个额外数组去储存排序结果在把它复制一遍回去
	private void mergeSort(int[] nums, int lstart, int lend, int rstart, int rend){
		int index = 0;
		int[] temp = new int[rend - lstart + 1];
		int i = lstart;
		int j = rstart;
		while(i <= lend && j <= rend){
			if(nums[i] < nums[j]){
				temp[index++] = nums[i++];
			}else{
				temp[index++] = nums[j++];
			}
		}
		while(i <= lend) temp[index++] = nums[i++];
		while(j <= rend) temp[index++] = nums[j++];
		for(int k = 0; k < temp.length; k++) nums[lstart + k] = temp[k];
	}
}