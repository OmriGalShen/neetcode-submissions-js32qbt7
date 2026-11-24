class Solution {
    /*
    N - nums.length

    dp[i] = maximum amount of money you can rob from nums[0,..,i]
    0 <= i <= N

    dp[i] = Max(nums[i-1] + dp[i-2], dp[i-1])

    base cases
    dp[0] = 0
    dp[1] = nums[0]

    result
    dp[n]

    time: O(N)
    space: O(1)
    */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n + 1];
        int prev2 = 0;
        int prev1 = nums[0];
        for (int i = 2; i <= n; i++) {
            int curr = Math.max(nums[i - 1] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
