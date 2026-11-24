class Solution {
    // time: O(N)
    // space: O(1)
    public int maxSubarraySumCircular(int[] nums) {
        int currMaxSum = 0;
        int currMinSum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = 0;
        for (int num : nums) {
            total += num;
            currMaxSum = Math.max(currMaxSum, 0) + num;
            currMinSum = Math.min(currMinSum, 0) + num;
            maxSum = Math.max(maxSum, currMaxSum);
            minSum = Math.min(minSum, currMinSum);
        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum, total-minSum);
    }
}