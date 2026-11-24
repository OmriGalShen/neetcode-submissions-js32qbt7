class Solution {
    /*
    N - s.length, M - wordDist.lengh, K = max(lengths in wordDist)

    dp[i] = can we segment s[0,..,i-1] into a space-separated sequence of dictionary words
    0 <= i <= N

    recursive form
    dp[i] = 
    if exists dp[j] = true && s[j,..,i-1] in wordDict

    base cases:
    dp[0] = true

    result
    dp[N]

    time:
    space:
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        // base case
        dp[0] = true;

        // bottom up
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        // result
        return dp[n];
    }
}
