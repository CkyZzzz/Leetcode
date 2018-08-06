//这道题其实不难, 时间复杂度T = O(n^2 * k) 
//注意两点 第一是结果中一组index的顺序问题，这个顺序表明必须按照这个顺序concatenation组成的字符串是回文字符串，
//第二点是其中一个判断中要注明 str2.length() != 0，这一步是为了避免重复。
class Solution {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		if(words == null || words.length < 2) return result;
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.length; i++) map.put(words[i], i);
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j <= words[i].length(); j++){
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if(isPalindrome(str1)){
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if(map.containsKey(str2rvs) && map.get(str2rvs) != i){
						List<Integer> list = new ArrayList<>();
						list.add(map.get(str2rvs));
						list.add(i);
						result.add(list);
					}
				}
				if(isPalindrome(str2)){
					String str1rvs = new StringBuilder(str1).reverse().toString();
					if(map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0){
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(map.get(str1rvs));
						result.add(list);
					}
				}
			}
		}
		return result;
	}
	private boolean isPalindrome(String str){
		for(int i = 0, j = str.length() - 1; i < j; i++, j--){
			if(str.charAt(i) != str.charAt(j)) return false;
		}
		return true;
	}
}