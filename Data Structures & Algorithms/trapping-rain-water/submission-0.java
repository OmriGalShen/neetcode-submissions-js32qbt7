class Solution {
    public int trap(int[] height) {
        int res = 0;
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int leftMax = 0, rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(height[i], leftMax);
            prefix[i] = leftMax;
            rightMax = Math.max(height[height.length - 1 - i], rightMax);
            suffix[height.length - 1 - i] = rightMax;
        }
        for (int i = 1; i < height.length - 1; i++) {
            int area = Math.max(0, Math.min(prefix[i], suffix[i]) - height[i]);
            res += area;
        }
        return res;
    }
}
