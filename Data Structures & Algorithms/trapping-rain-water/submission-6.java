class Solution {
    // time: O(N)
    // space: O(1)
    public int trap(int[] height) {
        int trap = 0;
        int l=0, r= height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        while(l <= r){
            if(height[l] < height[r]){
                trap += Math.max(0, maxLeft - height[l]);
                maxLeft = Math.max(maxLeft, height[l]);
                l++;
            } else{
                trap += Math.max(0, maxRight - height[r]);
                maxRight = Math.max(maxRight, height[r]);
                r--;
            }
        }
        return trap;
        
    }
}
