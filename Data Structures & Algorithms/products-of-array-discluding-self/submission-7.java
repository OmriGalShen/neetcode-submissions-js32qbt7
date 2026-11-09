class Solution {
    // time: O(N)
    // space: O(N)
    public int[] productExceptSelf(int[] nums) {
        // N - length of nums
        // guard
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // create result array of size N
        int[] result = new int[nums.length];

        int prefixAcc = 1;
        // go left to right, acculate product
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixAcc;
            prefixAcc *= nums[i];
        }

        // go right to left acculate product
        int suffixAcc = 1;
        for(int i = nums.length-1; i >= 0; i--){
            result[i] *= suffixAcc;
            suffixAcc *= nums[i];
        }

        // return
        return result;
    }
}
