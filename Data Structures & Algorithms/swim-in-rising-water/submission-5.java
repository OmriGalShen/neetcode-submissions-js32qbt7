class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // time: O(N^2*log(N))
    // space: O(N^2)
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dist = new int[n * n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = grid[0][0];

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {grid[0][0], 0});

        while (!minHeap.isEmpty()) {
            int[] val = minHeap.poll();
            int time = val[0];
            int gridIndex = val[1];
            int row = gridIndex / n;
            int col = gridIndex % n;

            if (gridIndex == n * n - 1) {
                return time;
            }

            if (dist[gridIndex] < time) {
                continue;
            }

            for (int[] direction : DIRECTIONS) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                int newGridIndex = nr * n + nc;
                int newTime = Math.max(time, grid[nr][nc]);
                if (newTime < dist[newGridIndex]) {
                    dist[newGridIndex] = newTime;
                    minHeap.offer(new int[] {newTime, newGridIndex});
                }
            }
        }

        return dist[n * n - 1];
    }
}
