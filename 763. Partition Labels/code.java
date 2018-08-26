class Solution {
	//方法一: T = O(n) S = O(1)
	public List<Integer> partitionLabels(String s) {
	    List<Integer> list = new ArrayList<>();
	    if(s == null || s.length() == 0) return list;
	    int[] map = new int[26];
	    for(int i = 0; i < s.length(); i++) map[s.charAt(i) - 'a'] = i;
	        int start = -1, end = 0;
		    for(int i = 0; i < s.length(); i++){
			    end = Math.max(end, map[s.charAt(i) - 'a']);
			    if(end == i){
				    list.add(end - start);
				    start = end;
			    }
		    }
	    return list;
	}
	
	//方法二: 扫描线 T = O(n), Collections.sort()方法最多就cover26个字母出现的位置
	private class Entry{
		int time;
		int flag;
		public Entry(int time, int flag){
			this.time = time;
			this.flag = flag;
		}
	}
	public List<Integer> partitionLabels(String s) {
		List<Entry> list = new ArrayList<>();
		Map<Character, Entry[]> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			if(map.containsKey(curr)){
				map.get(curr)[1].time = i;
			}else{
				map.put(curr, new Entry[]{new Entry(i, 0), new Entry(i, 1)});
			}
		}
		for(Map.Entry<Character, Entry[]> curr: map.entrySet()){
			Entry[] entry = curr.getValue();
			list.add(entry[0]);
			list.add(entry[1]);
		}
		Collections.sort(list, (a, b) -> (a.time == b.time ? a.flag - b.flag : a.time - b.time));
		List<Integer> result = new ArrayList<>();
		int prev = -1;
		int count = 0;
		for(Entry curr: list){
			if(curr.flag == 0) count++;
			if(curr.flag == 1) count--;
			if(count == 0){
				result.add(curr.time - prev);
				prev = curr.time;
			}
		}
		return result;
	}
}