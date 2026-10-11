class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> nodeToNeighbors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodeToNeighbors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodeToNeighbors.get(edge[0]).add(edge[1]);
            nodeToNeighbors.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                res++;
                dfs(i, seen, nodeToNeighbors);
            }
        }
        return res;
    }

    private void dfs(int node, boolean[] seen, List<List<Integer>> nodeToNeighbors) {
        seen[node] = true;
        for (int v : nodeToNeighbors.get(node)) {
            if (!seen[v]) {
                dfs(v, seen, nodeToNeighbors);
            }
        }
    }
}