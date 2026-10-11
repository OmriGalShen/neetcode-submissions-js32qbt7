class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> nodeToNeighbors = new HashMap<>();
        for (int[] edge : edges) {
            nodeToNeighbors.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            nodeToNeighbors.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int res = 0;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }
            res++;
            dfs(i, seen, nodeToNeighbors);
        }
        return res;
    }

    private void dfs(int node, boolean[] seen, Map<Integer, List<Integer>> nodeToNeighbors) {
        if (seen[node]) {
            return;
        }
        seen[node] = true;
        if (nodeToNeighbors.containsKey(node)) {
            for (int v : nodeToNeighbors.get(node)) {
                dfs(v, seen, nodeToNeighbors);
            }
        }
    }
}
