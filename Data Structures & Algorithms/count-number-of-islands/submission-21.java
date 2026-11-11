class Solution {
    private char[][] grid;
    private int N;
    private int M;
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    // N - grid rows, M - grid cols
    // time complexity: O(N * M)
    // space complexity: BFS O(Min(N,M)), DFS O(N * M)
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
                    bfs(r,c);
                }
            }
        }
        return numOfIslands;
    }

    private void bfs(int r, int c){
        grid[r][c] = '0';
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int[] direction: directions){
                int dr = direction[0];
                int dc = direction[1];
                int nr = row+dr;
                int nc = col+dc;
                if(nr >= 0 && nr < N && nc >=0 && nc < M && grid[nr][nc] == '1'){
                    grid[nr][nc] = '0';
                    queue.offer(new int[]{nr,nc});
                }

            }
        }
    }

}
