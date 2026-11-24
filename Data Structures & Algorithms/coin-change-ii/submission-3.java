class Solution {
    /*
    N - coins.length, T = amount

    dp[i][T] = the number of distinct combinations of coins[0,..,i-1] that total up to T
    0 <= i <= N
    0 <= j <= T

    recursive form:
    for i, j:
    op1 - take - dp[i][j-coins[i-1]] (j-coins[i-1] >= 0)
    op2 - skip - dp[i-1][j]
    dp[i][j] = max(op1, op2)

    base cases:
    dp[1 <= i <= n][0] = 1

    result
    dp[N][T]

    time: O(N*T)
    space: O(T)
    */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prevRow = new int[amount+1];
        int[] currRow = new int[amount+1];

        prevRow[0] = 1;
        currRow[0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                int op1 = (j-coins[i-1] >= 0)? currRow[j-coins[i-1]] : 0;
                int op2 = prevRow[j];
                currRow[j] = op1+op2;
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }
        return prevRow[amount];
    }
}
