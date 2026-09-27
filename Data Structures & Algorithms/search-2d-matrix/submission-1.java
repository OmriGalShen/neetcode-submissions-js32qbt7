class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length, M = matrix[0].length;
        int l = 0, r = N * M - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / M, col = m % M;
            if (target < matrix[row][col]) {
                r = m - 1;
            } else if (target > matrix[row][col]) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
