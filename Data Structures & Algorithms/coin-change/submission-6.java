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

    time: O(N*T)
    space: O(T)
    */
    public int coinChange(int[] coins, int amount) {
        // guard
        if(amount == 0){
            return 0;
        }
        if(coins == null || coins.length == 0){
            return -1;
        }

        // initialize
        int n = coins.length;
        int[] prevRow = new int[amount+1];
        int[] currRow = new int[amount+1];
        Arrays.fill(prevRow, amount + 1);
        Arrays.fill(currRow, amount + 1);
        prevRow[0] = 0;
        currRow[0] = 0;    

        // bottom up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int min = prevRow[j];
                if (j - coins[i - 1] >= 0) {
                    min = Math.min(min, 1 + currRow[j - coins[i - 1]]);
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
