class Solution {

    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>(); // charc, count
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }
            if (!stack.isEmpty() && stack.peek()[1] == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            sb.append(Character.toString(top[0]).repeat(top[1]));
        }
        return sb.reverse().toString();
    }
}