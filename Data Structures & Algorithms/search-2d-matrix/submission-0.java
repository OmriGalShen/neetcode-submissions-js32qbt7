class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length, M = matrix[0].length;
        int l = 0, r = N - 1;
        int row = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[m][0] > target) {
                r = m - 1;
            } else if (target > matrix[m][M - 1]) {
                l = m + 1;
            } else {
                row = m;
                break;
            }
        }
        if (row == -1) {
            return false;
        }
        l = 0;
        r = M - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[row][m] < target) {
                l = m + 1;
            } else if (matrix[row][m] > target) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
