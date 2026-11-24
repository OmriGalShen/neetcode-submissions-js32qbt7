class Solution {
    /*
    N - text1.length, M - text2.length

    dp[i][j] = Longest Common Subsequence of text1[0,..,i-1] and text2[0,..,j-1]
    0 <= i <= N
    0 <= j <= M

    dp[i][j] = 
    option 1 - if(text1[i-1] == text2[j-1]) 1 + dp[i-1][j-1]
    option 2 - dp[i-1][j]
    option 3 - dp[i][j-1]

    result
    dp[N][M]
    
    time: O(N*M)
    space: O(N*M)
    */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int op1 = (text1.charAt(i-1) == text2.charAt(j-1))? 1 + dp[i-1][j-1] : 0;
                int op2 = dp[i-1][j];
                int op3 = dp[i][j-1];
                dp[i][j] = Math.max(Math.max(op1,op2), op3);
            }
        }
        return dp[n][m];
    }
}
