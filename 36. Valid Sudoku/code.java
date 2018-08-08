class Solution {
    public boolean isValidSudoku(char[][] board) {
	    for(int i = 0; i < 9; i++) {
	    	char[] arr = board[i];
	    	if(!helper(arr)) return false;
	    	char[] arr2 = new char[9];
	    	for(int j = 0; j < 9; j++) arr2[j] = board[j][i];
	    	if(!helper(arr2)) return false;
			//别和后面follow up的题搞混了，这里的写法是要找出9个起始点(0, 0), (0, 3), (0, 6)
			//(3, 0), (3, 3), (3, 6), (6, 0), (6, 3), (6, 6)
	    	int x = i / 3 * 3;
	    	int y = i % 3 * 3;
	    	char[] arr3 = new char[9];
	    	int j = 0;
	    	for(int m = x; m < x + 3; m++) {
	    		for(int n = y; n < y + 3; n++) arr3[j++] = board[m][n];
	    	}
	    	if(!helper(arr3)) return false;
	    }	
	    return true;
	}
	    
	public boolean helper(char[] arr) {
	    Set<Character> set = new HashSet<>();
	    for(int i = 0; i < arr.length; i++) {
	    	if(set.contains(arr[i]) && arr[i] != '.') return false;
	    	set.add(arr[i]);
	    }
	    return true;
	}
}