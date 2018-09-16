class Solution {
	public char nextGreatestLetter(char[] letters, char target) {
		if(target < letters[0] || target >= letters[letters.length - 1]) return letters[0];
		
		for(int i = 0; i < letters.length; i++){
			if(letters[i] > target) return letters[i];
		}
		return 'a';
	}
}

class Solution {
	public char nextGreatestLetter(char[] letters, char target) {
		int start = 0, end = letters.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(letters[mid] > target) end = mid;
			else start = mid;
		}
		System.out.println(start + " " + end);
		if(end == letters.length - 1 && letters[end] <= target) return letters[0];
		if(start == 0 && letters[start] > target) return letters[start];
		return letters[end];
	}
}