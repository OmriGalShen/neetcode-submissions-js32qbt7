class Solution {
    /*

    def: N - nums.length
    time: O(n)
    space: O(1)
    */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num: nums){
            if(currSum < 0){
                currSum = 0;
            } 
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
