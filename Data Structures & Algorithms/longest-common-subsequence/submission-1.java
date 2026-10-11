class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length(), M = text2.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int r = N - 1; r >= 0; r--) {
            for (int c = M - 1; c >= 0; c--) {
                if (text1.charAt(r) == text2.charAt(c)) {
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
