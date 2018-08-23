/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		//***corner case***
		if(node == null) return null;
		//clone类型的题一律用map
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		//用一个bfs把所有的点都先clone一遍
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		set.add(node.label);
		map.put(node, new UndirectedGraphNode(node.label));
		while(!queue.isEmpty()){
			UndirectedGraphNode curr = queue.poll();
			for(UndirectedGraphNode adj: curr.neighbors){
				if(set.contains(adj.label)) continue;
				map.put(adj, new UndirectedGraphNode(adj.label));
				set.add(adj.label);
				queue.offer(adj);
			}
		}
		for(UndirectedGraphNode key: map.keySet()){
			UndirectedGraphNode copy = map.get(key);
			for(UndirectedGraphNode adj: key.neighbors){
				copy.neighbors.add(map.get(adj));
			}
		}
		return map.get(node);
	}
}