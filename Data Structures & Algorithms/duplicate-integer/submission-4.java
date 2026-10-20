class Solution {
    public boolean hasDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().count();
    }
}