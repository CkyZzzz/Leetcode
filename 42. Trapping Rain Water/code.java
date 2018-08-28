class Solution {
	//T = O(n), S = O(1)
	public int trap(int[] height) {
		int result = 0;
		if(height == null || height.length == 0) return result;
		int left = 0, right = height.length - 1;
		int leftMax = height[left], rightMax = height[right];
		while(left <= right){
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			//找两端值最小的，设想，如果只有左右两块板，那水平面一定和短板齐平
			if(leftMax < rightMax){
				result += leftMax - height[left];
				left++;
			}else{
				result += rightMax - height[right];
				right--;
			}
		}
		return result;
	}
}