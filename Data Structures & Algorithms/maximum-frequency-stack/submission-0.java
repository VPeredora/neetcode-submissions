class FreqStack {
    private Map<Integer, Integer> frequency;
    private Map<Integer, List<Integer>> groups;
    private int max = 0;

    public FreqStack() {
        frequency = new HashMap<>();
        groups = new HashMap<>();
    }
    
    public void push(int val) {
        frequency.merge(val, 1, Integer::sum);
        int freq = frequency.get(val);

        groups.computeIfAbsent(freq, k -> new ArrayList<>()).add(val);
        max = Math.max(max, freq);
    }
    
    public int pop() {
        List<Integer> stack = groups.get(max);
        int val = stack.remove(stack.size() - 1);

        if (stack.isEmpty()) max--;
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