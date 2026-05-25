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
        int min = stack.peek();

        while (!minimum.isEmpty())
            min = Math.min(minimum.pop(), min);
    
        return min;
    }
}
