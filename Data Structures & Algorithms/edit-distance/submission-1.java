class Solution {
    /*
    N - word1.length
    M - word2.length

    max = max(M,N) + 1

    dp[i][j] = minimum number of operations to make word1[0,..,i-1] equal word2[0,..,j-1]
    0 <= i <= N
    0 <= j <= M

    dp[i][j] =
    if word1[i-1] == word2[j-1]: dp[i-1][j-1]
    else:
        return 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])

    base cases

    result
    dp[N][M]

    time: O(N*M)
    space: O(N*M)
    */
    public int minDistance(String word1, String word2) {
        // guard

        // initialize
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = Math.max(n, m) + 1;

        // base cases
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        // bottom up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    min = dp[i - 1][j - 1];
                } else {
                    min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    min++;
                }
                dp[i][j] = min;
            }
        }

        // result
        return dp[n][m];
    }
}
