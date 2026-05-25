class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minimum;

    public MinStack() {
        stack = new ArrayDeque<>();
        minimum = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minimum.isEmpty() || val <= minimum.peek()) minimum.push(val);
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        if ((int) stack.pop() == minimum.peek()) minimum.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}
