class MinStack {
    private Deque<Integer> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Deque<Integer> minimum = new ArrayDeque<>(stack);
        int min = Integer.MAX_VALUE;

        while (minimum.size() > 0)
            min = Math.min(minimum.pop(), min);
    
        return min;
    }
}
