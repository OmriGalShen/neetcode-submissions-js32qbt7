class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = Map.of('}', '{', ']', '[', ')', '(');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (closeToOpen.containsValue(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char top = stack.pop();
                if (closeToOpen.get(c) != top) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
