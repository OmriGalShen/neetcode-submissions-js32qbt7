class Solution {
    /*
    many overlaping sub probems + optimum soultion -> dp
    def: N - coins.lengt, T = amount

    dp[i][j] = using coins[0,..i] minimum number of coins to get amount j
    recursive formula
    dp[i][j] =
    option 1 - skip coin - dp[i-1][j]
    option 2 - take coin - dp[i][j-coins[j]] (if j-coins[j] >= 0)
    dp[i][j] = min(option 1, option 2)

    base case:
    dp[0][coins[0]] = 1 (if coins[0] <= amount)

    result
    dp[N-1][T]

    time: O(N * T)
    space: O(N * T)
    */
    public int coinChange(int[] coins, int amount) {
        // guard
        if (coins == null) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        // initialize
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = amount + 1;
            }
        }

        // base case
        for (int j = coins[0]; j <= amount; j += coins[0]) {
            dp[0][j] = j / coins[0];
        }

        // fill up
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int min = dp[i - 1][j];
                if (j - coins[i] >= 0) {
                    min = Math.min(min, 1 + dp[i][j - coins[i]]);
                }
                dp[i][j] = min;
            }
        }

        // result
        return (dp[coins.length - 1][amount] == amount+1) ? -1
                                                                   : dp[coins.length - 1][amount];
    }
}
