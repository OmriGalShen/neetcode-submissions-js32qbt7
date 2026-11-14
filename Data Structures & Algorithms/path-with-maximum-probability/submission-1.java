class Solution {
    /*
    def: V - number of nodes, E - number of edges
    time:
    space: O(E+V)
    */
    public double maxProbability(
        int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            double prob = succProb[i];
            graph.get(v).add(new double[] {prob, u});
            graph.get(u).add(new double[] {prob, v});
        }
        double[] probabilities = new double[n];
        probabilities[start_node] = 1.0;
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        maxHeap.offer(new double[] {1, start_node});
        while (!maxHeap.isEmpty()) {
            double[] val = maxHeap.poll();
            double prob = val[0];
            int v = (int) val[1];
            if (prob < probabilities[v]) {
                continue;
            }
            if (v == end_node) {
                return prob;
            }
            for (double[] neighbor : graph.get(v)) {
                double probU = neighbor[0];
                int u = (int) neighbor[1];
                double newProb = probU * prob;
                if (newProb > probabilities[u]) {
                    probabilities[u] = newProb;
                    maxHeap.offer(new double[] {newProb, u});
                }
            }
        }
        return probabilities[end_node];
    }
}