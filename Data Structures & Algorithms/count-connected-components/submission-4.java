class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        int res = n;
        for (int[] edge : edges) {
            res -= union(parent, rank, edge[0], edge[1]);
        }
        return res;
    }

    private int find(int[] parent, int n) {
        if (parent[n] == n) {
            return n;
        }
        int res = find(parent, parent[n]);
        parent[n] = res;
        return res;
    }

    private int union(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        if (p1 == p2) {
            return 0;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }
}