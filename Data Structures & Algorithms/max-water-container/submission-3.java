class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int area = 0;
            if (heights[l] < heights[r]) {
                area = (r - l) * heights[l];
                l++;
            } else {
                area = (r - l) * heights[r];
                r--;
            }
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
