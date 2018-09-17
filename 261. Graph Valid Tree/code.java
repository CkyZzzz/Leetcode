class Solution {
	 //0 -> 3, 1 -> 2, 2 -> 1, 3 -> 1, 4 -> 1
	 public boolean validTree(int n, int[][] edges) {
	     List<Integer>[] graph = new List[n];
	     for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
	     Queue<Integer> queue = new LinkedList<>();
	     Set<Integer> set = new HashSet<>();
	     for(int i = 0; i < edges.length; i++){
	         int one = edges[i][0];
	         int two = edges[i][1];
	         graph[one].add(two);
	         graph[two].add(one);
	     }
	     int count = 1;
	     queue.offer(0);
	     set.add(0);
	     while(!queue.isEmpty()){
	         int curr = queue.poll();
	         for(int next: graph[curr]){
	             if(set.contains(next)) continue;
	             for(int adj: graph[next]){
	                 if(adj == curr) continue;
	                 if(set.contains(adj)) return false;
	             }
	             System.out.println(next);
	             queue.offer(next);
	             set.add(next);
	             count++;
	         }
	     }
	     return count == n;
	 }
}

class Solution {
	//这道题很巧妙的用到了uf的特性，uf简直就是处理图的神器，判断一个图是不是树有两个重要条件，一个是没有环，另一个就是所有点都是联通的
	private class UnionFind{
		private int[] map;
		private int count;
		public UnionFind(int size){
			map = new int[size];
			count = size;
			for(int i = 0; i < map.length; i++) map[i] = i;
		}
		public boolean union(int a, int b){
			int root_a = find(a);
			int root_b = find(b);
			if(root_a != root_b){
				map[root_a] = root_b;
				count--;
				return true;
			}
			return false;
		}
		private int find(int a){
			if(a == map[a]) return a;
			return map[a] = find(map[a]);
		}
		public int getCount(){
			return count;
		}
	}
	public boolean validTree(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for(int[] edge: edges){
			if(!uf.union(edge[0], edge[1])) return false;
		}
		return uf.getCount() == 1;
	}
}