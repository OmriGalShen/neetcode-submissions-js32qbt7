class Solution {
    private char[][] board;
    private String word;
    private int N;
    private int M;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.N = board.length;
        this.M = board[0].length;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (backtrack(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        char val = board[r][c];
        board[r][c] = '#';
        boolean found = (backtrack(r + 1, c, i + 1) || backtrack(r - 1, c, i + 1)
            || backtrack(r, c + 1, i + 1) || backtrack(r, c - 1, i + 1));
        board[r][c] = val;
        return found;
    }
}
