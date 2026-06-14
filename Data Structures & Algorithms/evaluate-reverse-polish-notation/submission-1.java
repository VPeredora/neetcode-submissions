class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokensList = new LinkedList<>(Arrays.asList(tokens));
        return evaluateRPN(tokensList);
    }

    private int evaluateRPN(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);

        if (!"+-*/".contains(token)) return Integer.parseInt(token);

        int right = evaluateRPN(tokens);
        int left = evaluateRPN(tokens);

        switch (token) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
        }

        return 0;
    }
}
