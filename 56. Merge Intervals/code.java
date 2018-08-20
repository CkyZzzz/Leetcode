class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) return result;
		Collections.sort(intervals, (a, b) -> (a.start - b.start));
		Interval target = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++){
			Interval curr = intervals.get(i);
			if(target.end < curr.start){
				result.add(target);
				target = curr;
			}else{
				target.end = Math.max(target.end, curr.end);
			}
		}
		result.add(target);
		return result;
	}
}