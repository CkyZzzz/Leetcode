class Solution {
	public String nextClosestTime(String time) {
		Set<Integer> set = new HashSet<>();
		set.add(time.charAt(0) - '0');
		set.add(time.charAt(1) - '0');
		set.add(time.charAt(3) - '0');
		set.add(time.charAt(4) - '0');
		String firstPart = "";
		String secondPart = "";
		int min = Integer.valueOf(time.substring(3));
		// 现在分钟上做判断，如果分钟上有最近的值，直接返回
		secondPart = helper(set, min + 1, 60);
		if(!secondPart.equals("")) return time.substring(0, 3) + secondPart;
		// 没有的话，就可以直接找4个数可以组成的最小分钟
		secondPart = helper(set, 0, 60);
		int hour = Integer.valueOf(time.substring(0, 2));
		// 然后在小时上做判断，如果小时上有最近的值，直接返回
		firstPart = helper(set, hour + 1, 24);
		if(!firstPart.equals("")) return firstPart + ":" + secondPart;
		// 没有的话，就直接找能组成的最小的小时
		firstPart = helper(set, 0, 24);
		return firstPart + ":" + secondPart;
	}
	private String helper(Set<Integer> set, int start, int end){
		for(int i = start; i < end; i++){
			String temp = "";
			if(i < 10) temp = "0";
			temp = temp + i;
			int first = temp.charAt(0) - '0';
			int second = temp.charAt(1) - '0';
			if(set.contains(first) && set.contains(second)) return first + "" + second;
		}
		return "";
	}
}