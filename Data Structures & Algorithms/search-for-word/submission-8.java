class Solution {
    private int N;
    private int M;
    private char[][] board;
    private String word;

    // N - board.length, M - board[0].length, K - word.length
    // time: O(N*M * 3^K)
    // space: O(K)
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        N = board.length;
        M = board[0].length;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (dfs(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || r >= N || c < 0 || c >= M || board[r][c] == '#') {
            return false;
        }
        char ch = board[r][c];
        if (word.charAt(i) != ch) {
            return false;
        }
        board[r][c] = '#';
        boolean result = dfs(r + 1, c, i + 1) || dfs(r - 1, c, i + 1) || dfs(r, c + 1, i + 1)
            || dfs(r, c - 1, i + 1);
        board[r][c] = ch;
        return result;
    }
}
