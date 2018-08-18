class Solution {
	// T = O(nlogn)
	public int kEmptySlots(int[] flowers, int k){
	    TreeSet<Integer> set = new TreeSet<>();
	    for(int i = 0; i < flowers.length; i++){
		    int curr = flowers[i];
			// 找出在树中比当前值大的最小值
		    Integer next = set.higher(curr);
		    if(next != null && next - curr == k + 1) return i + 1;
			// 找出在树中比当前值小的最大值, 实际上就是找里target value最近的值
		    Integer prev = set.lower(curr);
		    if(prev != null && curr - prev == k + 1) return i + 1;
		    set.add(curr);
	    }
	    return -1;
	}
}