class Solution {
    /*
    N - stones.length
    S - total sum

    dp[i][j] - maximum weight we can get to with subset from stotes[0,..,N-1], with capacity j
    (0 <= j <= S/2)

    recurisve:
    dp[i][j] =
    option 1 - skip - dp[i-1][j]
    option 2 - take - dp[i-1][j-stones[i]] + stones[i] (j >= stones[i])
    dp[i][j] = Max(option 1, option2)

    base cae:
    dp[0][stones[0],..., S/2] = stones[0]

    result:
    S - 2*dp[N-1][S/2]

    time: O(N*S)
    space: O(N*S)
    */
    public int lastStoneWeightII(int[] stones) {
        // guard
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        int totalSum = 0;
        for (int weight : stones) {
            totalSum += weight;
        }
        int target = totalSum / 2;
        // initialize
        int[][] dp = new int[stones.length][target + 1];

        // base case
        for (int weight = stones[0]; weight <= target; weight++) {
            dp[0][weight] = stones[0];
        }

        // fillup
        for (int i = 1; i < stones.length; i++) {
            for (int weight = 0; weight <= target; weight++) {
                int skip = dp[i - 1][weight];
                int take = 0;
                if (weight - stones[i] >= 0) {
                    take = stones[i] + dp[i - 1][weight - stones[i]];
                }
                dp[i][weight] = Math.max(skip, take);
            }
        }

        // result
        return totalSum - 2 * dp[stones.length - 1][target];
    }
}