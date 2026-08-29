class MinStack {
    private Deque<StackNode> stack;
    record StackNode(int val, int min){};

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int newMin = val;
        if(!this.stack.isEmpty()){
            newMin = Math.min(val, this.getMin());
        }
        this.stack.push(new StackNode(val, newMin));
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
