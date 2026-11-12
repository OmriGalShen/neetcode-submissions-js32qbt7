class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // def: N - grid.length, M = grid[0].length
    // time: O(N*M)
    // space: O(Min(N, M))
    public int maxAreaOfIsland(int[][] grid) {
        // guard
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = bfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        int area = 1;
        grid[r][c] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(r*m + c);
        while (!queue.isEmpty()) {
            int encoded = queue.poll();
            int row = encoded / m;
            int col = encoded % m;
            for (int[] direction : DIRECTIONS) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && grid[nr][nc] == 1) {
                    area++;
                    grid[nr][nc] = 0;
                    queue.offer(nr*m + nc);
                }
            }
        }
        return area;
    }
}
