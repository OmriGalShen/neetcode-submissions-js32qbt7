class Solution {
    // time: O(log(N +M))
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;
        int row = N - 1;
        int col = 0;
        while (row >= 0 && col < M) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
