class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build Graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(graph, src, dest, 1.0, visited);
            }
        }

        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       String curr,
                       String target,
                       double product,
                       Set<String> visited) {

        if (curr.equals(target))
            return product;

        visited.add(curr);

        for (String next : graph.get(curr).keySet()) {
            if (!visited.contains(next)) {
                double ans = dfs(graph, next, target,
                        product * graph.get(curr).get(next),
                        visited);

                if (ans != -1.0)
                    return ans;
            }
        }

        return -1.0;
    }
}