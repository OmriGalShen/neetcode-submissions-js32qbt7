class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] square = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j] - '0' - 1;
                if (rows[i][val]) {
                    return false;
                }
                rows[i][val] = true;
                if (cols[j][val]) {
                    return false;
                }
                cols[j][val] = true;
                if (square[(i / 3)*3 + j / 3][val]) {
                    return false;
                }
                square[(i / 3)*3 + j / 3][val] = true;
            }
        }
        return true;
    }
}
