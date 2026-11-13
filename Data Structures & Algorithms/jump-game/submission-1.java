class Solution {
    /*

    def: N - nums.length
    time: O(N)
    space: O(1)

    nums = [1,2,0,1,0]
    jumpCount = 1
    */
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
