class Solution {
    int N;
    int M;
    String word;
    char[][] board;

    record Cell(int row, int col) {}

    public boolean exist(char[][] board, String word) {
        this.N = board.length;
        this.M = board[0].length;
        this.board = board;
        this.word = word;

        for (int r = 0; r < this.N; r++) {
            for (int c = 0; c < this.M; c++) {
                Set<Cell> set = new HashSet<>();
                if (exist(r, c, set, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int r, int c, Set<Cell> set, int i) {
        if (r < 0 || r >= this.N || c < 0 || c >= this.M || board[r][c] == '#') {
            return false;
        }
        if (i == this.word.length() || this.board[r][c] != this.word.charAt(i)) {
            return false;
        }
        i++;
        if (i == this.word.length()) {
            return true;
        }
        char val = this.board[r][c];
        this.board[r][c] = '#';
        boolean res = exist(r + 1, c, set, i) || exist(r - 1, c, set, i) || exist(r, c + 1, set, i)
            || exist(r, c - 1, set, i);
        board[r][c] = val;
        return res;
    }
}
