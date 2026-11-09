class Solution {

    // time: 9^2 
    // space: 9 + 9 + 9
    public boolean isValidSudoku(char[][] board) {
        // guard
        if(board == null){
            return false;
        }
        // set up memory to check rows, cols and squares
        boolean[][] rowsSeen = new boolean[9][9];
        boolean[][] colsSeen = new boolean[9][9];
        boolean[][] squaresSeen = new boolean[9][9];
        
        // itreation of all elemenets, for each checking if valid
        // valid - either '.' or isn't dup
        // invalid - early return false
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char ch = board[r][c];
                if(ch == '.'){
                    continue;
                }
                int val = ch - '0'-1;
                if(rowsSeen[r][val]){
                    return false; 
                }
                rowsSeen[r][val] = true;
                if(colsSeen[c][val]){
                    return false;
                }
                colsSeen[c][val] = true;
                int squreIndex = ((r / 3) *3) + (c/3);
                if(squaresSeen[squreIndex][val]){
                    return false;
                }
                squaresSeen[squreIndex][val] = true;
            }
        }
        // all valid - return true
        return true;
    }
}
