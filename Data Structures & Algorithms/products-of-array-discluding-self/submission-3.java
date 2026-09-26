class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int acc = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = acc;
            acc *= nums[i];
        }
        acc = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= acc;
            acc *= nums[i];
        }
        return res;
    }
}
