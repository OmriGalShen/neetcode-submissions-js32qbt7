class Solution {
    /*

    def: N - nums.length
    time: O(N)
    space: O(1)

    nums = [1,2,0,1,0]
    jumpCount = 1
    */
    public boolean canJump(int[] nums) {
        int jumpCount = 1;
        
        for(int num: nums){
            jumpCount --;
            if(jumpCount < 0){
                return false;
            }
            jumpCount = Math.max(jumpCount, num);
        }
        return true;
    }
}
