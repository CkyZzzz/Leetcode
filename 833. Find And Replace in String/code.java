class Solution {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < indexes.length; i++) map.put(indexes[i], i);
		Arrays.sort(indexes);
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		for(int i = 0; i < indexes.length; i++){
			int startIndex = indexes[i];
			for(int j = prev; j < startIndex; j++){
				sb.append(S.charAt(j) + "");
			}
			prev = startIndex;
			String source = sources[map.get(startIndex)];
			String target = targets[map.get(startIndex)];
			String temp = S.substring(startIndex, startIndex + source.length());
			if(source.equals(temp)){
				sb.append(target);
				prev += + source.length();
			}
		}
		return sb.toString() + S.substring(prev);
	}
}