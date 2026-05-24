class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray())
            if (map.containsKey(c)) stack.push(c);
            else if (stack.isEmpty() || map.get(stack.pop()) != c) return false;

        return stack.isEmpty();
    }
}
