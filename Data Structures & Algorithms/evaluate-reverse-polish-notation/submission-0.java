class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int second = stack.pop();
                int first = stack.pop();

                if (token.equals("+")) stack.push(first + second);
                else if (token.equals("-")) stack.push(first - second);
                else if (token.equals("*")) stack.push(first * second);
                else if (token.equals("/")) stack.push(first / second);

            } else stack.push(Integer.valueOf(token));
        }

        return stack.pop();
    }
}
