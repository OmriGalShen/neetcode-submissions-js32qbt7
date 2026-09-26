class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = Map.of('}', '{', ']', '[', ')', '(');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (closeToOpen.get(c) != top) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
