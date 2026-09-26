public class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '1';
                if (row[r][val]) {
                    return false;
                }
                row[r][val] = true;
                if (col[c][val]) {
                    return false;
                }
                col[c][val] = true;
                int block_index = (r / 3) * 3 + (c / 3);
                if (block[block_index][val]) {
                    return false;
                }
                block[block_index][val] = true;
            }
        }
        return true;
    }
}
