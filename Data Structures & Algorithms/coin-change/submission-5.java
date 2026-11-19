class Solution {
    /*
    N - coins.length
    T - amount
    dp[i][j] = fewest number of coins in coins[0,..i] to make j
    0 <= i <= N
    0 <= j <= amount
    for i, j:
        option 1 - skip - dp[i-1][j]
        option 2 - take - 1 + dp[i][j-coins[i]], if j-coins[i] >= 0
    dp[i][j] = option 1 + option 2

    base:
    dp[0][j * n] = 1, for other it's amount + 1

    result:
    dp[N-1][T]

    time:
    space:
    */
    public int coinChange(int[] coins, int amount) {
        // guard

        // initialize
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[0], amount + 1);
        dp[0][0] = 0;

        // bottom up
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
            for (int j = 1; j <= amount; j++) {
                int min = dp[i-1][j];
                if (j - coins[i - 1] >= 0) {
                    min = Math.min(min, 1 + dp[i][j - coins[i - 1]]);
                }
                dp[i][j] = min;
            }
        }

        // result
        return (dp[n][amount] == amount + 1) ? -1 : dp[n][amount];
    }
}
