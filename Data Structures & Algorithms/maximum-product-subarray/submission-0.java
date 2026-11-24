class Solution {
    // time: O(N)
    // sapce: O(1)
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin = 1;
        int res = nums[0];
        for (int num : nums) {
            int product = currMax * num;
            currMax = Math.max(Math.max(product, num), currMin*num);
            currMin = Math.min(Math.min(product, num), currMin*num);
            res = Math.max(res, currMax);
        }
        return res;
    }
}
