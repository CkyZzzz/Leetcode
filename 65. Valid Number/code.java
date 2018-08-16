class Solution {
	//
	//                            3------>4------>5
	//                            |
	//        0 ------> 1 ------> 2
	//                            |
	//                            6------>7
	// 0 -> 1 through +, -
	// 1 -> 2 trhough digit
	// 0 -> 2 trhough digit
	// 0 -> 6 through dot
	// 1 -> 6 through dot
	// 2 -> 6 through dot
	// 2 -> 3 through exp
	// 6 -> 3 through exp
	// 7 -> 3 through exp
	// 3 -> 5 through digit
	// 3 -> 4 through +, -
	// 4 -> 5 through digit
	public boolean isNumber(String s) {
		s = s.trim();
		int state = 0;
		boolean flag = false;
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			if(Character.isDigit(curr)){
				flag = true;
				if(state <= 2) state = 2;
				else if(state <= 5) state = 5;
				else state = 7;
			}else if(curr == '+' || curr == '-'){
				if(state == 0 || state == 3) state++;
				else return false;
			}else if(curr == '.'){
				if(state <= 2) state = 6;
				else return false;
			}else if(curr == 'e'){
				if(flag && (state == 2 || state == 6 || state == 7)) state = 3;
				else return false;
			}else{
				return false;
			}
		}
		return state == 2 || flag && state == 6 || state == 5 || state == 7; 
	}
}