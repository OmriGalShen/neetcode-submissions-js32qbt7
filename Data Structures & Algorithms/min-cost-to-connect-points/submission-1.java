class Solution {
    /*
    def: N - points.length
    time: O(E * log(E) + V^2)  = O(E*LogE + V^2) = O(V^2*LogV + V^2) = O(V^2*LogV) = O(N^2*LogN)
    space: O(E) = O(V^2) = O(N^2)
    */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] pointA = points[0];
        for (int j = 1; j < n; j++) {
            int[] pointB = points[j];
            int distance = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
            minHeap.offer(new int[] {distance, 0, j});
        }
        int totalCost = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (visited.size() < n) {
            int[] val = minHeap.poll();
            int distance = val[0];
            int i = val[1];
            int j = val[2];
            if (visited.contains(j)) {
                continue;
            }
            totalCost += distance;
            pointA = points[j];
            for (int k = 0; k < n; k++) {
                if (visited.contains(k) || k == j) {
                    continue;
                }
                int[] pointB = points[k];
                distance = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
                minHeap.offer(new int[] {distance, 0, k});
            }
            visited.add(j);
        }
        return totalCost;
    }
}
