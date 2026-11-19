class Solution {
    /*
    N - s.length
    M - t.length

    dp[i][j] = number of distict subsequences of s[0,..,i-1] equal t[0,...,j-1]
    0 <= i <= N
    0 <= j <= M
    recursive form
    for d[i][j]:
    if s[i-1] == t[j-1]
        dp[i-1][j-1] + dp[i-1][j]
    else:
        dp[i-1][j-1]

    time: 
    space: 
    */
    public int numDistinct(String s, String t) {
        // guard
        if(s.length() < t.length()){
            return 0;
        }

        // initiliaze
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        // base cases
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        // bottom up
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // result
        return dp[n][m];
    }
}
