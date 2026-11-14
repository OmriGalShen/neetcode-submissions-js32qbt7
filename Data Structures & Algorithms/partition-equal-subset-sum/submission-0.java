class Solution {
    /*
    def: N - nums.length, S - sum(nums)
    [1,3,2,2]
    do we have subarray with sum S/2
    if S%2 != 0: false

     dp[i][j] = do we have sub set in nums[0..i] with sum j
     d[i][j] = dp[i-1][j - nums[i]] || dp[i-1][j]

    base case:
    dp[0][nums[0]] = true

    time:
    space:
    */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];

        // initialize
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // fill up
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }
}
