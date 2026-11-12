class Solution {
    // def: N - nums.length
    // time: O(N)
    // space: O(1)
    public int maxSubArray(int[] nums) {
        // guard
        if(nums.length == 1){
            return nums[0];
        }
        int currSum = nums[0];
        int maxSum = currSum;
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(currSum + num > num){
                currSum += num;
            } else{
                currSum = num;
            }
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
