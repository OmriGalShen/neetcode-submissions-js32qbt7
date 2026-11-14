class Solution {
    /*
    def: N - nums.length, T - target, L - total sum absolute

    dp[i][j] = how many different ways we can sum nums[0...i] to target
    recursive defintion:
    dp[i][j] = dp[i-1][j - nums[i]] + dp[i-1][j + nums[i]]
    dp - size of N * 2*L+1

    base case:
    dp[0][nums[0]] = 1, dp[0][-nums[0]] = 1, other values for dp[0] should be 0

    time: O(N*L)
    space: O(N*L)
    */
    public int findTargetSumWays(int[] nums, int target) {
        // guard
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int totalSumAbs = 0;
        for (int num : nums) {
            totalSumAbs += Math.abs(num);
        }

        if (Math.abs(target) > totalSumAbs) {
            return 0;
        }

        int[][] dp = new int[nums.length][totalSumAbs * 2 + 1];

        // initialize
        dp[0][nums[0] + totalSumAbs] = 1;
        dp[0][-nums[0] + totalSumAbs] += 1;

        // fill up
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2 * totalSumAbs; j++) {
                int count = 0;
                if (j - nums[i] >= 0) {
                    count += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < totalSumAbs * 2 + 1) {
                    count += dp[i - 1][j + nums[i]];
                }
                dp[i][j] = count;
            }
        }

        // result
        return dp[nums.length - 1][target + totalSumAbs];
    }
}
