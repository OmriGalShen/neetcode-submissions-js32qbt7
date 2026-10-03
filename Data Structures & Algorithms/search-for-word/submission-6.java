class Solution {
    private int N;
    private int M;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.N = board.length;
        this.M = board[0].length;
        this.board = board;
        this.word = word;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (bfs(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int r, int c, int i) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return false;
        }
        if (i == word.length()) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        i++;
        if (i == word.length()) {
            return true;
        }
        char val = board[r][c];
        board[r][c] = '.';
        boolean found =
            bfs(r + 1, c, i) || bfs(r - 1, c, i) || bfs(r, c + 1, i) || bfs(r, c - 1, i);
        board[r][c] = val;
        return found;
    }
}