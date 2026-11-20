class Solution {
    /*
    N - s1.length
    M - s2.length

    dp[i][j] = can i form s3[0,...,i+j-1] by interleaving s1[0,..,i-1] and s2[0,..,j-1]
    0 <= i <= N
    0 <= j <= M
    recursive form:
    dp[i][j] =
    if s3[i+j-1] == s1[i-1] and s3[i+j-1] == s2[j-1]:
        dp[i-1][j] or dp[i][j-1]
    else if s3[i+j-1] == s1[i-1]:
        dp[i-1][j]
    else if s3[i+j-1] == s2[j-1]:
        dp[i][j-1]
    else:
        false

    // base cases
    dp[0][0] = true
    dp[1<=i<= N][0] = true if dp[i-1][0] = true and s3[i-1] == s1[i-1]
    dp[0][1 <= j <= M] = true if dp[0][j-1] = true and s3[j-1] == s2[j-1]

    // result
    dp[N][M]

    time: O(N*M)
    space: O(N*M)

    */
    public boolean isInterleave(String s1, String s2, String s3) {
        // guard
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // initialize
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // base cases
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // bottom up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean possible = false;
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)
                    && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    possible = dp[i - 1][j] || dp[i][j - 1];
                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    possible = dp[i - 1][j];
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    possible = dp[i][j - 1];
                }
                dp[i][j] = possible;
            }
        }

        // result
        return dp[n][m];
    }
}
