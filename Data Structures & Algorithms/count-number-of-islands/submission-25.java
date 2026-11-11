class Solution {
    private char[][] grid;
    private int N;
    private int M;
    // for directions 
    private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    // N - grid rows, M - grid cols
    // time complexity: O(N * M)
    // space complexity: O(N * M)
    public int numIslands(char[][] grid) {
        // guard
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;  
        int numOfIslands = 0;
        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                if(grid[r][c] == '1'){
                    numOfIslands++;
                    dfs(r,c);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(int r, int c){
        if(r < 0 || r >= N || c < 0 || c >= M || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] direction: DIRECTIONS){
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            dfs(newRow, newCol);
        }
    }

}
