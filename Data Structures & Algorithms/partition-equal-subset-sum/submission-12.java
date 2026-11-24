class Solution {
    /*
    N - nums.length, S - sum(nums)

    dp[i][j] = is there a subset in nums[0,..,i-1] with sum of j

    recursive form:
    dp[i][j] = dp[i-1][j] or (dp[i-1][j-nums[i-1]] && (j-nums[i-1] >= 0))

    base case:
    dp[0 <= i <= N][0] = true

    result:
    dp[N][S/2]

    time: O(N*T)
    space: O(N*T)
    */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        // base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] |= (j - nums[i - 1] >= 0) && dp[i-1][j - nums[i - 1]];
            }
        }

        return dp[n][target];
    }
}
