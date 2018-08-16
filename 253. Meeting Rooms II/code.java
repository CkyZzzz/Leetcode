class Solution {
	//贪心 T = O(nlogn)
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals.length == 0) return 0;
		Arrays.sort(intervals, (a, b) -> (a.start - b.start));
		PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> (a.end - b.end));
		heap.offer(intervals[0]);
		for(int i = 1; i < intervals.length; i++){
			Interval curr = heap.poll();
			if(curr.end <= intervals[i].start){
				curr.end = intervals[i].end;
			}else{
				heap.offer(intervals[i]);
			}
			heap.offer(curr);
		}
		return heap.size();
	}
	
	//segment line
	private class Entry{
		int time;
		int flag;
		public Entry(int time, int flag){
			this.time = time;
			this.flag = flag;
		}
	}
	public int minMeetingRooms(Interval[] intervals) {
		PriorityQueue<Entry> heap = new PriorityQueue<>((a, b) -> (a.time == b.time ? b.flag - a.flag : a.time - b.time));
		for(Interval interval: intervals){
			heap.offer(new Entry(interval.start, 0));
			heap.offer(new Entry(interval.end, 1));
		}
		int count = 0;
		int result = 0;
		while(!heap.isEmpty()){
			Entry curr = heap.poll();
			if(curr.flag == 0) count++;
			else count--;
			result = Math.max(result, count);
		}
		return result;
	}
}