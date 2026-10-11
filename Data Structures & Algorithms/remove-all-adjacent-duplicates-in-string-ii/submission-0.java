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
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] val = stack.pop();
            list.add(Character.toString(val[0]).repeat(val[1]));
        }
        return String.join("", list.reversed());
    }
}