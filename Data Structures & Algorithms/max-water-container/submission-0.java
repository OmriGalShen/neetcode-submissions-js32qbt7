class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int max = 0;
        do {
            int curr = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(max, curr);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        } while (l < r);
        return max;
    }
}
