class Solution {
	private class UnionFind{
		private int[] map;
		private int count;
		public UnionFind(int num){
			map = new int[num];
			count = num;
			for(int i = 0; i < map.length; i++) map[i] = i;
		}
		public void union(int a, int b){
			int root_a = find(a);
			int root_b = find(b);
			if(root_a != root_b){
				map[root_a] = root_b;
				count--;
			}
		}
		private int find(int a){
			if(map[a] == a) return a;
			return map[a] = find(map[a]);
		}
		public int getCount(){
			return count;
		}
	}
	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for(int[] edge: edges){
			uf.union(edge[0], edge[1]);
		}
		return uf.getCount();
	}
}