class Solution {
	//可以不用PriorityQueue!!!
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bans = new HashSet<>();
		for(String word: banned) bans.add(word);
		paragraph = paragraph.toLowerCase();
		paragraph += "#";
		String word = "";
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < paragraph.length(); i++){
			char curr = paragraph.charAt(i);
			if(Character.isLetter(curr)){
				word += curr;
			}else{
				//注意这三行的写法
				if(word.equals("")) continue;
				if(!bans.contains(word)) map.put(word, map.getOrDefault(word, 0) + 1);
				word = "";
			}
		}
		int count = 0;
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			if(entry.getValue() > count){
				count = entry.getValue();
				word = entry.getKey();
			}
		}
		return word;
	}
}