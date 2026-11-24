class Solution {
    /*

    dp[i] = number of distinct ways to climb to get to level i
    0 <= i <= n

    dp[i] = dp[i-1] + dp[i-2]

    base case:
    dp[1] = 1
    dp[2] = 1

    result
    dp[n] + dp[n-1]

    time: O(N)
    space: O(N)
    */
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n] + dp[n - 1];
    }
}
