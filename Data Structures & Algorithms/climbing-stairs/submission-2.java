class Solution {
    // def:  N - n,
    // move - either 1 or 2 steps
    // dp[m] = number of distict moves to get to m staircase
    // time: O(N)
    // space: O(N)
    public int climbStairs(int n) {
        // guard
        if (n < 1) {
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
