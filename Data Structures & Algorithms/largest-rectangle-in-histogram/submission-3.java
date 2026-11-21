class Solution {
    // time: O(N)
    // space: O(N)
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int j = stack.pop();
                int leftBound = (stack.isEmpty()) ? -1 : stack.peek();
                int area = (i - leftBound - 1) * heights[j];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int leftBound = (stack.isEmpty()) ? -1 : stack.peek();
            int area = (heights.length - leftBound - 1) * heights[j];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
