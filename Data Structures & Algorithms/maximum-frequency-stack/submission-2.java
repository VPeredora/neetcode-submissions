class FreqStack {
    private Map<Integer, Integer> frequency;
    private List<Deque<Integer>> stacks;

    public FreqStack() {
        frequency = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new ArrayDeque<>());
    }
    
    public void push(int val) {
        frequency.merge(val, 1, Integer::sum);
        int freq = frequency.get(val);

        if (freq == stacks.size()) stacks.add(new ArrayDeque<>());
        stacks.get(freq).push(val);
    }
    
    public int pop() {
        Deque<Integer> stack = stacks.get(stacks.size() - 1);
        int result = stack.pop();

        if (stack.isEmpty()) stacks.remove(stacks.size() - 1);
        frequency.merge(result, -1, Integer::sum);
        
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */