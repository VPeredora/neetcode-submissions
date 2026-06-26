class Solution {
    public int calculate(String s) {
        Deque<Integer> calculator = new ArrayDeque<>();
        String expression = s.replaceAll("\\s+", "");
        int number = 0;
        char sign = '+';

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) number = number * 10 + (c - '0');

            if (!Character.isDigit(c) || i == expression.length() - 1) {
                if (sign == '+') calculator.push(number);
                else if (sign == '-') calculator.push(-number);
                else if (sign == '*' || sign == '/') {
                    int first = calculator.pop();
                    int result = sign == '*' ? first * number : first / number;
                    calculator.push(result);
                }
                number = 0;
                sign = c;
            }
        }

        int result = 0;
        while (!calculator.isEmpty())
            result += calculator.pop();

        return result;
    }
}