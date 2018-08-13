class Solution {
	public String alienOrder(String[] words) {
		if(words == null || words.length == 0) return "";
		String result = "";
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> indegree = new HashMap<>();
		for(String word: words){
			for(int i = 0; i < word.length(); i++){
				char curr = word.charAt(i);
				if(!map.containsKey(curr)){
					map.put(curr, new HashSet<>());
					indegree.put(curr, 0);
				}
			}
		}
		if(words.length == 1){
			for(Character letter: map.keySet()) result += letter;
			return result;
		}
		for(int i = 1; i < words.length; i++){
			String prev = words[i - 1];
			String curr = words[i];
			for(int j = 0; j < Math.min(prev.length(), curr.length()); j++){
				char prevC = prev.charAt(j);
				char currC = curr.charAt(j);
				if(prevC != currC){
					// if(map.get(currC).contains(prevC)) return "";
					//注释掉的这句话看似可以解决图中环的情况，但其实是错的，他只能解决图中相邻的两个字母之前是否有环，也就是
					// -------
					//   |_|
					// 但更多时候会出现以下这种情况
					// -----------
					//   |____|
					//所以最好的办法就是加上这句 if(result.length() != indegree.size()) return "";
					if(!map.get(prevC).contains(currC)){
						map.get(prevC).add(currC);
						indegree.put(currC, indegree.get(currC) + 1);
					}
					//不能把break放到!map.get(prevC).contains(currC)这句判断里，原因是之前判断过先后关系的两个单词
					//本身已经区别了二者的顺序，后面的字母排序是无效的
					break;
				}
			}
		}
		Queue<Character> queue = new LinkedList<>();
		for(Character c: indegree.keySet()){
			if(indegree.get(c) == 0){
				queue.offer(c);
			}
		}
		while(!queue.isEmpty()){
			char curr = queue.poll();
			result += curr;
			for(Character next: map.get(curr)){
				indegree.put(next, indegree.get(next) - 1);
				if(indegree.get(next) == 0){
					queue.offer(next);
				}
			}
		}
		if(result.length() != indegree.size()) return "";
		return result;
	}
}