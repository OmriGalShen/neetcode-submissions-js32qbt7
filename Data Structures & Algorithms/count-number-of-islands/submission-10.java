class Solution {
    int N;
    int M;
    char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.N = grid.length;
        this.M = grid[0].length;
        int res = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    explore(r, c);
                }
            }
        }
        return res;
    }

    private void explore(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        explore(r + 1, c);
        explore(r - 1, c);
        explore(r, c + 1);
        explore(r, c - 1);
    }
}
