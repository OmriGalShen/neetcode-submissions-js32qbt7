class Solution {
    private int n;
    private int m;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        int res = 0;
        this.n = grid.length;
        this.m = grid[0].length;
        this.visited = new boolean[this.n][this.m];

        for (int r = 0; r < this.n; r++) {
            for (int c = 0; c < this.m; c++) {
                if (grid[r][c] == '1' && !this.visited[r][c]) {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= this.n || c < 0 || c >= this.m || grid[r][c] == '0'
            || this.visited[r][c]) {
            return;
        }
        this.visited[r][c] = true;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
