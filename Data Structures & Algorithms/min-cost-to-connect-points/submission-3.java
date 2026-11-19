class Solution {
    /*
    V - points.length, E = V^2
    time: O(E * log(E)) = O(V^2* log(V))
    space: O(E) = O(V^2)
    */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int j = 1; j < n; j++) {
            int[] a = points[0];
            int[] b = points[j];
            int dist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
            minHeap.offer(new int[] {dist, 0, j});
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int totalCost = 0;
        while (visited.size() < n) {
            int[] val = minHeap.poll();
            int dist = val[0];
            int i = val[1];
            int j = val[2];
            if (visited.contains(j)) {
                continue;
            }
            visited.add(j);
            totalCost += dist;
            for (int k = 0; k < n; k++) {
                if (k == j || visited.contains(k)) {
                    continue;
                }
                int[] a = points[j];
                int[] b = points[k];
                int newDist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                minHeap.offer(new int[] {newDist, j, k});
            }
        }
        return totalCost;
    }
}
