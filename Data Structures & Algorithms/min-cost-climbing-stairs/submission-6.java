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
    space: O(1)
    */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 2; i <= n; i++) {
            int curr = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
