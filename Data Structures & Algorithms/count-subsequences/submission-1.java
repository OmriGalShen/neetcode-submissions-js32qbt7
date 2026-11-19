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

    time: O(N*M)
    space: O(M)
    */
    public int numDistinct(String s, String t) {
        // guard
        if(s.length() < t.length()){
            return 0;
        }

        // initiliaze
        int n = s.length();
        int m = t.length();
        int[] prevRow = new int[m+1];
        int[] currRow = new int[m+1];

        // base cases

        // bottom up
        for(int i=1;i<=n;i++){
            prevRow[0] = 1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    currRow[j] = prevRow[j] + prevRow[j-1];
                } else{
                    currRow[j] = prevRow[j];
                }
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        // result
        return prevRow[m];
    }
}
