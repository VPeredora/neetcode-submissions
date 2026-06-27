class FreqStack {
    private Map<Integer, Integer> frequency;
    private Map<Integer, Deque<Integer>> groups;
    private int max = 0;

    public FreqStack() {
        frequency = new HashMap<>();
        groups = new HashMap<>();
    }
    
    public void push(int val) {
        frequency.merge(val, 1, Integer::sum);
        int freq = frequency.get(val);

        groups.computeIfAbsent(freq, k -> new ArrayDeque<>()).push(val);
        max = Math.max(max, freq);
    }
    
    public int pop() {
        int val = groups.get(max).pop();

        if (groups.get(max).isEmpty()) max--;
        frequency.merge(val, -1, Integer::sum);

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */