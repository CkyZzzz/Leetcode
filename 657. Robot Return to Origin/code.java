class Solution {
	public boolean judgeCircle(String moves) {
		int[] position = new int[]{0, 0};
		for(int i = 0; i < moves.length(); i++){
			char curr = moves.charAt(i);
			if(curr == 'U'){
				position[0]++;
			}else if(curr == 'D'){
				position[0]--;
			}else if(curr == 'L'){
				position[1]--;
			}else{
				position[1]++;
			}
		}
		return position[0] == 0 && position[1] == 0;
	}
}