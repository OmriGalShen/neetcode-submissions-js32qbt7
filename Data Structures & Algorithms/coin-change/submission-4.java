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
    space: O(T)
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
        int[] prevRow = new int[amount + 1];
        Arrays.fill(prevRow, amount + 1);
        prevRow[0] = 0;
        int[] currRow = new int[amount + 1];
        Arrays.fill(currRow, amount + 1);
        currRow[0] = 0;

        // fill up
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int min = prevRow[j];
                if (j - coins[i] >= 0) {
                    min = Math.min(min, 1 + currRow[j - coins[i]]);
                }
                currRow[j] = min;
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        // result
        return (prevRow[amount] == amount + 1) ? -1 : prevRow[amount];
    }
}
