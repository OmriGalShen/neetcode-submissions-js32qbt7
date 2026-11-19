class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        k--;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        List<List<int[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int t = edge[2];
            adj.get(a).add(new int[] {t, b});
        }
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0, k});

        while (!minHeap.isEmpty()) {
            int[] val = minHeap.poll();
            int distToB = val[0];
            int b = val[1];
            if (dist[b] < distToB) {
                continue;
            }
            for (int[] edge : adj.get(b)) {
                int weight = edge[0];
                int neighbor = edge[1];
                int distToNeighbor = distToB + weight;
                if (dist[neighbor] > distToNeighbor) {
                    dist[neighbor] = distToNeighbor;
                    minHeap.offer(new int[] {distToNeighbor, neighbor});
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dist[i]);
        }
        return (max == Integer.MAX_VALUE) ? -1 : max;
    }
}
