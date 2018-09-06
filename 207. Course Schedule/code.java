class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new List[numCourses];
		for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
		int[] indegree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		for(int i = 0; i < prerequisites.length; i++){
			int prev = prerequisites[i][1];
			int curr = prerequisites[i][0];
			graph[prev].add(curr);
			indegree[curr]++;
		}
		for(int i = 0; i < indegree.length; i++){
			if(indegree[i] == 0){
				queue.offer(i);
				count++;
			}
		}
		while(!queue.isEmpty()){
			int curr = queue.poll();
			for(int next: graph[curr]){
				if(--indegree[next] == 0){
					queue.offer(next);
					count++;
				}
			}
		}
		return numCourses == count;
	}
}