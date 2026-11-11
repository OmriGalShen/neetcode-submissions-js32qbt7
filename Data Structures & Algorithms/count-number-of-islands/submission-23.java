class Solution {
    private char[][] grid;
    private int N;
    private int M;
    // for directions 
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
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
        grid[r][c] = '0';
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(r*M + c);
        while(!queue.isEmpty()){
            int nodeVal = queue.pop();
            int row = nodeVal / M;
            int col = nodeVal % M;
            for(int[] direction: directions){
                int nr = row+direction[0];
                int nc = col+direction[1];
                if(nr >= 0 && nr < N && nc >=0 && nc < M && grid[nr][nc] == '1'){
                    grid[nr][nc] = '0';
                    queue.push(nr*M+nc);
                }

            }
        }
    }

}
