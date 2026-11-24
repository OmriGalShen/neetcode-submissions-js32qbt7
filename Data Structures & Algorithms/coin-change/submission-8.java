class Solution {
    /*
    N - coins.length, T - amount

    dp[i][j] = minimum number of coins in coins[0,..,i-1] to get to amount

    dp[i][j] = 
    1. take - dp[i][j - coins[i-1]], if j - coins[i-1] >= 0
    2. skip - dp[i-1][j]
    dp[i][j] = min(take, skip)

    max = amount+1

    base cases
    dp[0][j != 0] = max
    dp[0 <= i <= N][0] = 0 

    result:
    dp[N][T]

    time: O(N*T)
    space: O(T)
    */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int max = amount+1;
        int[] prevRow = new int[amount+1];
        int[] currRow = new int[amount+1];

        for(int j=1;j<=amount;j++){
            prevRow[j] = max;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                int take = (j - coins[i-1] >= 0)? 1 + currRow[j - coins[i-1]] : max;
                int skip = prevRow[j];
                currRow[j] = Math.min(take, skip);
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        return (prevRow[amount] == max)? -1: prevRow[amount];
        
    }
}
