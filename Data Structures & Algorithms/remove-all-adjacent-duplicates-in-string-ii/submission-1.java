class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) stack.peek()[1]++;
            else stack.push(new int[] {c, 1});

            if (stack.peek()[1] == k) stack.pop();
        }

        StringBuilder result = new StringBuilder();
        for (int[] c : stack)
            result.append(String.valueOf((char) c[0]).repeat(c[1]));

        return result.reverse().toString();
    }
}