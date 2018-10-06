class Solution {
	public int myAtoi(String str) {
		long result = 0;
		int sign = 1;
		boolean isStart = false;
		for(int i = 0; i < str.length(); i++){
			char curr = str.charAt(i);
			if(!isStart && curr != '+' && curr != '-' && !Character.isDigit(curr) && curr != ' ') return 0;
			if(!isStart && (curr == '+' || curr == '-' || Character.isDigit(curr))){
				if(curr == '-') sign = -1;
				if(Character.isDigit(curr)) result = 10 * result + (curr - '0');
				isStart = true;
				continue;
			}
			if(isStart){
				if(!Character.isDigit(curr)) break;
				result = 10 * result + (curr - '0');
				if(result * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
				if(result * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
			}
		}
		return sign * ((int) result);
	}
}