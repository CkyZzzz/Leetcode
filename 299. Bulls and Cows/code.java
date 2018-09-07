class Solution {
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int sum = 0;
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> gMap = new HashMap<>();
		for(int i = 0; i < secret.length(); i++){
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if(s == g) bulls++;
			sMap.put(s, sMap.getOrDefault(s, 0) + 1);
			gMap.put(g, gMap.getOrDefault(g, 0) + 1);
		}
		for(Map.Entry<Character, Integer> entry: sMap.entrySet()){
			if(gMap.containsKey(entry.getKey())){
				int sCnt = entry.getValue();
				int gCnt = gMap.get(entry.getKey());
				if(gCnt > sCnt){
					sum += sCnt;
				}else{
					sum += gCnt;
				}
			}
		}
		cows = sum - bulls;
		return bulls + "A" + cows + "B";
	}
}