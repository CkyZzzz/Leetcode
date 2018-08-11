class Solution {
	//T = O(E)
	public boolean isBipartite(int[][] graph) {
		Set<Integer> part1 = new HashSet<>();
		Set<Integer> part2 = new HashSet<>();
		Set<Integer> nodes = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < graph.length; i++){
			//注意j < graph[i].length;而不是j < graph[0].length; 每一个子数组长度是不一样的
			//nodes里的点表示图中组成边的点，孤立的点并不在nodes里，因为他们并不影响是不是bipartite graph
			for(int j = 0; j < graph[i].length; j++){
				nodes.add(graph[i][j]);
			}
		}
		while(!nodes.isEmpty()){
			int start = nodes.iterator().next();
			//易遗漏点
			nodes.remove(start);
			queue.offer(start);
			part1.add(start);
			int level = 0;
			//这里我们采用的是bfs的一层一层搜索的方式
			while(!queue.isEmpty()){
				int size = queue.size();
				for(int i = 0; i < size; i++){
					int curr = queue.poll();
					if(level % 2 == 0){
						for(int adj: graph[curr]){
							if(part1.contains(adj)) return false;
							if(!part2.contains(adj)){
								part2.add(adj);
								queue.offer(adj);
								nodes.remove(adj);
							}
						}
					}else{
						for(int adj: graph[curr]){
							if(part2.contains(adj)) return false;
							if(!part1.contains(adj)){
								part1.add(adj);
								queue.offer(adj);
								nodes.remove(adj);
							}
						}
					}
				}
				level++;
			}
		}
		return true;
	}
}