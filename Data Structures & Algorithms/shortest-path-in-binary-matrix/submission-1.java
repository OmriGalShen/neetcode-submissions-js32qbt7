class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        if (grid[0][0] != 0) {
            return -1;
        }
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int len = cell[2];
            if (row == N - 1 && col == N - 1) {
                return len;
            }
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || grid[newRow][newCol] == 1 || visited[newRow][newCol]) {
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol, len + 1});
            }
        }
        return -1;
    }
}
