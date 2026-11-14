class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;

        while (r < nums.length) {
            while (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                r++;
            }
            nums[l] = nums[r];
            l++;
            r++;
        }
        return l;
    }
}