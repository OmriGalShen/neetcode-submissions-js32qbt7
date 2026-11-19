class Solution {
    /*
    N - text1.length
    M  - text2.length

    dp[i][j] = lcs in text1[0,.., i-1] and text[0,..,j-1]
    0 <= i <= N
    0 <= j <= M

    recursive form:
    dp[i][j] =
    if text1[i-1] == text2[j-1]:
        1 + dp[i-1][j-1]
    else:
        max(dp[i-1][j], dp[i][j-1])

    base cases
    dp[0,...,N][0] = 0
    dp[0][0,...,M] = 0

    result
    dp[N][M]

    time:
    space:
    */
    public int longestCommonSubsequence(String text1, String text2) {
        // guard
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }
        int n = text1.length();
        int m = text2.length();
        // initialize
        int[][] dp = new int[n + 1][m + 1];

        // base cases

        // bottom up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // result
        return dp[n][m];
    }
}
