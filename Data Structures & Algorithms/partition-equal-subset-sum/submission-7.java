class Solution {
    /*
    def:
    N - nums.length
    T - sum(nums)

    target = T/2

    dp[i][j] - is there a subset in nums[0,..,i] with sum of j
    0 <= i <= N-1
    0 <= j <= T/2
    recursive form:
    for i,j
    option 1 - we have subset in num[0...,i-1] with sum of j
    option 2 - we have subject in nums[0,...,i-1] with sum of num[i]
    dp[i][j] = (option 1) || option 2

    base case:
    dp[0,...N-1][0] = true

    result:
    dp[N-1, target]

    time: O(N*T)
    space: O(T)

    */
    public boolean canPartition(int[] nums) {
        // guard
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;

        // initialize
        boolean[] prevRow = new boolean[target + 1];
        boolean[] currRow = new boolean[target + 1];

        // bottom up
        for (int i = 1; i < n; i++) {
            prevRow[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean prev = prevRow[j];
                boolean take = (j - nums[i] >= 0) && prevRow[j - nums[i]];
                currRow[j] = prev || take;
            }
            boolean[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        // result
        return prevRow[target];
    }
}
