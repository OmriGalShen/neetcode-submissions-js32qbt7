class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closeToOpen = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (stack.isEmpty() || !closeToOpen.get(c).equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}