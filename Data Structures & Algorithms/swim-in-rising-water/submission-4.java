class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] distance = new int[n * m];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = grid[0][0];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {grid[0][0], 0});
        while (!minHeap.isEmpty()) {
            int[] val = minHeap.poll();
            int time = val[0];
            int node = val[1];
            int r = node / m;
            int c = node % m;

            if (time > distance[node]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return time;
            }

            for (int[] direction : DIRECTIONS) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                int newNode = nr * m + nc;
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                int newTime = Math.max(time, grid[nr][nc]);
                if (newTime < distance[newNode]) {
                    distance[newNode] = newTime;
                    minHeap.offer(new int[] {newTime, newNode});
                }
            }
        }
        return distance[n * m - 1];
    }
}
