class Solution {
    // time: O(N)
    // space: O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return result;
    }
}
