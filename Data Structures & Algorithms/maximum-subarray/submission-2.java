class Solution {
    // time: O(N)
    // space: O(1)
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int currSum =0;
        for(int num: nums){
            currSum = Math.max(0, currSum) + num;
            result = Math.max(result, currSum);
        }
        return result;
    }
}
