class Solution {
    /*
    N = cost.length

    dp[i] = minimum cost to reach level 0
    0 <= i <= N

    dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])

    base cases
    dp[0] = 0
    dp[1] = 0

    result
    dp[n]

    time: O(N)
    space: O(N)
    */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
