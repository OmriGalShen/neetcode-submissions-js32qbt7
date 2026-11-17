class Solution {
    record Point(int x, int y) {}
    /*
    def: N - points.length
    time: O(V * log(E) + V^2)  = O(V^2) = O(N^2)
    space: O(E) = O(V^2) = O(N^2)
    */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] pointA = points[i];
                int[] pointB = points[j];
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }
        }
        int[] pointA = points[0];
        for (int neighbor : adjList.get(0)) {
            int[] pointB = points[neighbor];
            int distance = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
            minHeap.offer(new int[] {distance, 0, neighbor});
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
            for (int neighbor : adjList.get(j)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                int[] pointB = points[neighbor];
                distance = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
                minHeap.offer(new int[] {distance, 0, neighbor});
            }
            visited.add(j);
        }
        return totalCost;
    }
}
