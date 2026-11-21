class Solution {
    // time: O(1)
    // space: O(1)
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0' - 1;
                if (rows[r][val]) {
                    return false;
                }
                rows[r][val] = true;
                if (cols[c][val]) {
                    return false;
                }
                cols[c][val] = true;
                int square = (r / 3) * 3 + c / 3;
                if (squares[square][val]) {
                    return false;
                }
                squares[square][val] = true;
            }
        }
        return true;
    }
}
