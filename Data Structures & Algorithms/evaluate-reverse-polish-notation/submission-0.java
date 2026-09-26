class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+": {
                    int a = stack.pop(), b = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    int a = stack.pop(), b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case "*": {
                    int a = stack.pop(), b = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int a = stack.pop(), b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}