class Solution {
    private static class UnionFind{
        private int[] parent;
        private int[] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        // time: O(alpha(N)) ~ O(1)
        public int find(int v){
            if(parent[v] != v){
                parent[v] = find(parent[v]); // path compression
            }
            return parent[v];
        }

        // time: O(alpha(N)) ~ O(1)
        public boolean union(int v, int u){
            int rootV = find(v);
            int rootU = find(u);
            if(rootV == rootU){
                return false;
            }
            if(size[rootV] < size[rootU]){
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            } else{
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            }
            return true;
        }
    }
    /*
    time: E*log(E)
    space: O(E)
    */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int[] a = points[i];
                int[] b = points[j];
                int dist = Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
                minHeap.offer(new int[]{dist, i, j});
            }
        }
        UnionFind uf = new UnionFind(n);

        int totalCost = 0;
        int edgeCount = 0;
        while(edgeCount < n-1){
            int[] val = minHeap.poll();
            int dist = val[0];
            int a = val[1];
            int b = val[2];
            if(!uf.union(a,b)){
                continue;
            }
            totalCost += dist;
            edgeCount++;
        }
        return totalCost;
    }
}
