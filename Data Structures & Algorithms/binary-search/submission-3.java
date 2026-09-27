class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = nums[m];
            if (sum > target) {
                r = m - 1;
            } else if (sum < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
