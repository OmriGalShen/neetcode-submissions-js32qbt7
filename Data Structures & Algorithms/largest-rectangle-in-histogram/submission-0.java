class Solution {
    record Bar(int index, int height) {
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Bar> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            int start = i;
            while (!stack.isEmpty() && currHeight < stack.peek().height) {
                Bar bar = stack.pop();
                int area = (i - bar.index()) * bar.height();
                maxArea = Math.max(maxArea, area);
                start = bar.index();
            }
            stack.push(new Bar(start, currHeight));
        }
        while (!stack.isEmpty()) {
            Bar bar = stack.pop();
            int area = (heights.length - bar.index()) * bar.height();
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
