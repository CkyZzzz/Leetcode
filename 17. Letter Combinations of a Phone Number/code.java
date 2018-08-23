class Solution {
	String[][] dict = new String[][]{
		{},
		{},
		{"a", "b", "c"},
		{"d", "e", "f"},
		{"g", "h", "i"},
		{"j", "k", "l"},
		{"m", "n", "o"},
		{"p", "q", "r", "s"},
		{"t", "u", "v"},
		{"w", "x", "y", "z"}
	};
	// public List<String> letterCombinations(String digits) {
	//     List<String> result = new ArrayList<>();
	//     if(digits.indexOf("0") != -1 || digits.indexOf("1") != -1 || digits.equals("")) return result;
	//     helper(digits, 0, "", result);
	//     return result;
	// }
	// private void helper(String digits, int index, String path, List<String> result){
	//     if(index == digits.length()){
	//         result.add(path);
	//         return;
	//     }
	//     String[] letters = dict[digits.charAt(index) - '0'];
	//     for(int i = 0; i < letters.length; i++){
	//         helper(digits, index + 1, path + letters[i], result);
	//     }
	// }
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits.indexOf("0") != -1 || digits.indexOf("1") != -1 || digits.equals("")) return result;
		result.add("");
		for(int i = 0; i < digits.length(); i++){
			String[] letters = dict[digits.charAt(i) - '0'];
			List<String> tempList = new ArrayList<>();
			for(String temp: result){
				for(int j = 0; j < letters.length; j++){
					tempList.add(temp + letters[j]);
				}
			}
			result = tempList;
		}
		return result;
	}
}