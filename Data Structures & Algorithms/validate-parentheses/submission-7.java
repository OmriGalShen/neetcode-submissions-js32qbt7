class Solution {
    // def: N - s.lenth()
    // time: O(N)
    // space: O(N)
    public boolean isValid(String s) {
        // guard 
        if(s == null || s.isEmpty()){
            return true;
        }
        Map<Character, Character> closeToOpen = Map.of(')','(', ']','[', '}','{');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(closeToOpen.containsKey(c)){
                if(stack.isEmpty() || closeToOpen.get(c) != stack.peek()){
                    return false;
                }
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
