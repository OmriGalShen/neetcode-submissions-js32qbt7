class Solution {
    private static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int v) {
            if (parent[v] != v) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }

        public boolean union(int v, int u) {
            int rootV = find(v);
            int rootU = find(u);

            if (rootV == rootU) {
                return false;
            }
            if (size[rootV] < size[rootU]) {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            } else {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] resultEdge = null;

        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            int v = edge[0]-1;
            int u = edge[1]-1;
            if(!uf.union(v, u)){
                resultEdge = edge;
            }
        }
        return resultEdge;
    }
}
