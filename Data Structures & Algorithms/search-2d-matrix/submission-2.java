class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;
        int l = 0, r = N * M - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / M;
            int col = m % M;
            int val = matrix[row][col];
            if (val > target) {
                r = m - 1;
            } else if (val < target) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
