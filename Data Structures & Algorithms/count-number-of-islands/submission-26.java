class Solution {
    private char[][] grid;
    private int N;
    private int M;
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // time: O(N*M)
    // space: O(min(N,M))
    public int numIslands(char[][] grid) {
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;
        int islandCount = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    bfs(r, c);
                }
            }
        }
        return islandCount;
    }

    private void bfs(int r, int c) {
        grid[r][c] = '0';
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(r * M + c);
        while (!queue.isEmpty()) {
            int cell = queue.poll();
            int row = cell / M;
            int col = cell % M;
            for (int[] direction : DIRECTIONS) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.offer(nr * M + nc);
                }
            }
        }
    }
}
