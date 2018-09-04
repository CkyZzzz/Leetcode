class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if(s.length() < 4 || s.length() > 12) return result;
		helper(s, 0, new ArrayList<>(), result);
		return result;
	}
	private void helper(String s, int startIndex, List<String> path, List<String> result){
		//s.length() + 4 == path.length() && dotCount == 4 也可以作为判断标准
		if(path.size() == 4){
			if(startIndex == s.length()){
				String address = "";
				for(int i = 0; i < 4; i++){
					if(i == 3) address += path.get(i);
					else address += path.get(i) + ".";
				}
				result.add(address);
			}
			return;
		}
		for(int i = startIndex; i < s.length() && i < startIndex + 3; i++){
			String temp = s.substring(startIndex, i + 1);
			if(Integer.valueOf(temp) > 255) break;
			path.add(temp);
			helper(s, i + 1, path, result);
			path.remove(path.size() - 1);
			//只会计算一种0的情况，而不会出现后面的001这类情况
			if(s.charAt(startIndex) == '0') break;
		}
	}
}