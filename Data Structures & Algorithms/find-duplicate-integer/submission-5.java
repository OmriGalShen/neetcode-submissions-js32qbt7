class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (slow == 0 || slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2 = 0;
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow2;
    }
}
