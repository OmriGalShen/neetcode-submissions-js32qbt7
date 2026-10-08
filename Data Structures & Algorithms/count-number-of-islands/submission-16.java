class Solution {
    char[][] grid;
    int N;
    int M;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.N = grid.length;
        this.M = grid[0].length;
        int res = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    bfs(r, c);
                }
            }
        }
        return res;
    }

    private void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        grid[r][c] = 0;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M
                    && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = 0;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
    }
}
