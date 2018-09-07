/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution{
	public int maxPoints(Point[] points) {
		if(points == null) return 0;
		if(points.length <= 2) return points.length;	
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		int result = 0;
		for(int i = 0; i < points.length - 1; i++){
			//这一步也很关键，之前求的和后面求的会有重复，所以必须先把之前求的删掉
			map.clear();
			//overlap 是用来考虑原数组中存在同一个位置有多个点的
			int overlap = 0, max = 0;
			for(int j = i + 1; j < points.length; j++){
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if(x == 0 && y == 0){
					overlap++;
					continue;
				}
				int gcd = generateGCD(x, y);
				//gcd == 0的情况即x == 0, 说明这两个点x值相等，y值不相等，也就是说这俩点在一条与y轴平行的线上
				if(gcd != 0){
					x /= gcd;
					y /= gcd;
				}		
				if(map.containsKey(x)){
					if(map.get(x).containsKey(y)){
						map.get(x).put(y, map.get(x).get(y) + 1);
					}else{
						map.get(x).put(y, 1);
					}   					
				}else{
					Map<Integer,Integer> temp = new HashMap<>();
					temp.put(y, 1);
					map.put(x, temp);
				}
				max = Math.max(max, map.get(x).get(y));
			}
			//加一表示还包括i对应的这个点
			result = Math.max(result, max + overlap + 1);
		}
		return result;	
	}
	// Because slope is stored as an irreducible fraction. Once you get the line equation to y = ax + b
	// where a is a fractional slope, to be able to compare it to other lines' slopes, you need its 
	// numerator & denomintor to be reduced to the smallest values possible.
	// GCD -> Greatest Common Divisor -> 最大公约数
	// e.g.
	// a = 10, b = 2;
	// generateGCD(2, 0);
	// return 2;
	// a = 9, b = 2;
	// generateGCD(2, 1);
	// generateGCD(1, 0);
	// return 1;
	// a = 0, b = 12;
	// generateGCD(12, 0);
	// return 12;
	// a = 12, b = 0;
	// return 12;
	private int generateGCD(int a, int b){
		if(b == 0) return a;
		else return generateGCD(b, a % b);	
	}
}