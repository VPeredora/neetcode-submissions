class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                int amount = stack.peek()[1] + 1;
                
                if (amount == k) {
                    while (!stack.isEmpty() && --amount > 0)
                        stack.pop();
                } else stack.push(new int[] {c, amount});

            } else stack.push(new int[] {c, 1});
        }

        StringBuilder result = new StringBuilder();
        for (int[] c : stack)
            result.append((char) c[0]);

        return result.reverse().toString();
    }
}