class Solution {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] result = new double[queries.length];
		Map<String, List<String>> graph = new HashMap<>();
		Map<String, Double> coe = new HashMap<>();
		buildGraph(equations, values, graph, coe);
		for(int i = 0; i < queries.length; i++){
			String[] query = queries[i];
			Set<String> used = new HashSet<>();
			used.add(query[0]);
			result[i] = helper(graph, coe, used, query[0], query[1], 1.0);
		}
		return result;
	}
	private void buildGraph(String[][] equations, double[] values, Map<String, List<String>> graph, Map<String, Double> coe){
		for(int i = 0; i < equations.length; i++){
			String[] equation = equations[i];
			if(!graph.containsKey(equation[0])) graph.put(equation[0], new ArrayList<>());
			if(!graph.containsKey(equation[1])) graph.put(equation[1], new ArrayList<>());
			graph.get(equation[0]).add(equation[1]);
			graph.get(equation[1]).add(equation[0]);
			coe.put(equation[0] + "/" + equation[1], values[i]);
			coe.put(equation[1] + "/" + equation[0], 1 / values[i]);
		}
	}
	private double helper(Map<String, List<String>> graph, Map<String, Double> coe, Set<String> used, String start, String end, double val){
		if(graph.containsKey(start) && graph.containsKey(end) && start.equals(end)) return val;
		if(!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
		List<String> list = graph.get(start);
		for(String next: list){
			if(used.contains(next)) continue;
			used.add(next);
			double result = helper(graph, coe, used, next, end, val * coe.get(start + "/" + next));
			if(result != -1.0) return result;
			used.remove(next);
		}
		return -1.0;
	}
}