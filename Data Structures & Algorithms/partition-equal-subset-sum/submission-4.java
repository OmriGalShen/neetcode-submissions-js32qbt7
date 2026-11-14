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

    time: O(N * S)
    space: O(N * S)
    */
    public boolean canPartition(int[] nums) {
        // guard
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // initialize
        boolean[] prevRow = new boolean[target + 1];
        boolean[] currRow = new boolean[target + 1];
        prevRow[0] = true;
        if (nums[0] <= target) {
            prevRow[nums[0]] = true;
        }

        // fill up
        for (int i = 1; i < nums.length; i++) {
            Arrays.fill(currRow, false);
            currRow[0] = true;
            for (int j = 1; j <= target; j++) {
                currRow[j] = prevRow[j];
                if (j - nums[i] >= 0) {
                    currRow[j] |= prevRow[j - nums[i]];
                }
            }
            boolean[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        return prevRow[target];
    }
}
