class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            int val = 0;
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                val = a + b;
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                val = a - b;
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                val = a * b;
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                val = a / b;
            } else {
                val = Integer.parseInt(token);
            }
            stack.push(val);
        }
        return stack.peek();
    }
}
