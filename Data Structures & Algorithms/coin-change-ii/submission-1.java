class Solution {
    /*
    N - coins.lengh
    T - amount

    dp[i][j] =  number of distinct combinations of coins[0,.. i] that total up to amount j
    dp - N * (T+1)

    recursive definition:
    dp[i][j] =
    option 1 - skip - dp[i-1][j]
    option 2 - take - dp[i][j-coins[i]], j-coins[i] >= 0 else 0
    dp[i][j] = option 1 + option 2

    base case:
    dp[0][coins[0]] = dp[0][2*coins[0]] ... = 1
    dp[0..N-1][0] = 1

    result:
    dp[N-1][T]

    time: O(N*T)
    space: O(N*T)

    */
    public int change(int amount, int[] coins) {
        int[] prevRow = new int[amount + 1];
        int[] currRow = new int[amount + 1];

        for (int i = 0; i < coins.length; i++) {
            currRow[0] = 1;
            for (int j = 1; j <= amount; j++) {
                int skip = prevRow[j];
                int take = (j - coins[i] >= 0) ? currRow[j - coins[i]] : 0;
                currRow[j] = skip + take;
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        return prevRow[amount];
    }
}
