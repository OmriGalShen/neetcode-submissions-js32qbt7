class Solution {
    /*
    L - strs.length
    M - m
    N - n
    S - max string length

    dp[i][j][k] = size of largest subset strs[0,...,i] at most j 0's and at most k 1's
    recurisve def:
    dp[i][j][k] =
    option 1 - don't use current strs[i] - dp[i-1][j][k]
    option 2 - use current strs[i] j >= zeros in strs[i] and k >= ones in strs[i], 1 +
    dp[i-1][j-zeros][k-ones] dp[i][j][k] = max(option 1, option 2)

    base case:
    if strs[0] zeros >= m and strs[0] >= n:
        dp[0][0...zeros][0...ones] = 1

    result
    dp[L-1][M][N]

    time: O(L *( S + N*M))
    space: O(L*M*N)
    */
    public int findMaxForm(String[] strs, int m, int n) {
        // guard
        if (strs == null || strs.length == 0) {
            return 0;
        }

        // initialize
        int[][] prevRow = new int[m + 1][n + 1];
        int[][] currRow = new int[m + 1][n + 1];

        // base case
        int zeroCount = 0;
        int oneCount = 0;
        for (char c : strs[0].toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        for (int i = zeroCount; i <= m; i++) {
            for (int j = oneCount; j <= n; j++) {
                prevRow[i][j] = 1;
            }
        }

        // fill up
        for (int i = 1; i < strs.length; i++) {
            zeroCount = 0;
            oneCount = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int skip = prevRow[j][k];
                    int take = 0;
                    if (zeroCount <= j && oneCount <= k) {
                        take = 1 + prevRow[j - zeroCount][k - oneCount];
                    }
                    currRow[j][k] = Math.max(skip, take);
                }
            }
            prevRow = currRow;
            currRow = new int[m + 1][n + 1];
        }

        // result
        return prevRow[m][n];
    }
}