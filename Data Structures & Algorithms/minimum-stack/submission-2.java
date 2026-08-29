class MinStack {
    private Deque<StackNode> stack;
    record StackNode(int val, int min){};

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int newMin =  this.stack.isEmpty() ? val : Math.min(this.stack.peek().min, val);
        StackNode newNode = new StackNode(val, newMin);
        this.stack.push(newNode);
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek().val;
    }
    
    public int getMin() {
        return this.stack.peek().min;
    }
}
