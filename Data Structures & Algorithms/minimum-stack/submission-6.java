class MinStack {
    private final Deque<Val> stack;

    record Val(int val, int min) {
    }

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int newMin = val;
        if (!stack.isEmpty()) {
            newMin = Math.min(val, getMin());
        }
        stack.push(new Val(val, newMin));
    }

    public void pop() {
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek().val();
    }

    public int getMin() {
        return this.stack.peek().min();
    }
}
