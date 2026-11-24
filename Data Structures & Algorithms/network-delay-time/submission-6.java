class Solution {
    // time: O(E*log(E))
    // space: O(V)
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<int[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int a = time[0] - 1;
            int b = time[1] - 1;
            int weight = time[2];
            adj.get(a).add(new int[] {weight, b});
        }

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0, k - 1});
        dist[k-1] = 0;
        while (!minHeap.isEmpty()) {
            int[] val = minHeap.poll();
            int distToSrc = val[0];
            int src = val[1];
            if (dist[src] < distToSrc) {
                continue;
            }
            for (int[] neighbor : adj.get(src)) {
                int neighborWeight = neighbor[0];
                int neighborNode = neighbor[1];
                if (distToSrc + neighborWeight < dist[neighborNode]) {
                    dist[neighborNode] = distToSrc + neighborWeight;
                    minHeap.offer(new int[] {dist[neighborNode], neighborNode});
                }
            }
        }
        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }
        return (maxDist == Integer.MAX_VALUE) ? -1 : maxDist;
    }
}
