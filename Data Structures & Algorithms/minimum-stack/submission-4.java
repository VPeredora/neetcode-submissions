class MinStack {
    private Deque<Long> stack;
    private long min;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {min = val; stack.push(0L);}
        else {
            stack.push(val - min); 
            min = Math.min(val, min);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        long top = stack.pop();
        if (top < 0) min = min - top;
    }
    
    public int top() {
        long top = stack.peek();
        if (top < 0) return (int) min;
        else return (int) (top + min);
     }
    
    public int getMin() {
        return (int) min;
    }
}
