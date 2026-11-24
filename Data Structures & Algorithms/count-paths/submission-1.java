class Solution {
    /*

    dp[i][j] = number of possible unique paths that can be taken from the top-left corner of the grid to grid[i][j]
    0 <= i < M
    0 <= j < N

    dp[i][j] = dp[i-1][j] + dp[i][j-1]

    base case:
    dp[0][0 <= j < M] = 1
    dp[0 <= i < N][0] = 1

    return dp[M-1][N-1]

    time: O(N*M)
    space: O(M)
    */
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        int[] currRow = new int[n];

        for(int j=0;j<n;j++){
            prevRow[j] = 1;
        }
        currRow[0] = 1;

        for(int i=1;i<m;i++){
            for(int j=1;j< n;j++){
                currRow[j] = prevRow[j] + currRow[j-1];
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        return prevRow[n-1];
    }
}
