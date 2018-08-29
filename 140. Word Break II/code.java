class Solution {
	//记忆化搜索
	Map<String, List<String>> map = new HashMap<>();
	public List<String> wordBreak(String s, List<String> wordDict) {
		if(map.containsKey(s)) return map.get(s);
		List<String> result = new ArrayList<>();
		if(s.equals("")){
			result.add("");
			return result;
		}else{
			for(String word: wordDict){
				if(s.startsWith(word)){
					List<String> tempList = wordBreak(s.substring(word.length()), wordDict);
					for(String temp: tempList){
						result.add(word + (temp.equals("") ? "": " ") + temp);
					}
				}
			}
		}
		map.put(s, result);
		return result;
	}
}