class MinStack {
    Deque<Integer> stack;
    int minimum = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        minimum = Math.min(minimum, val);
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
