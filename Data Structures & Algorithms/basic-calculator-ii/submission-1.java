class Solution {
    public int calculate(String s) {
        int total = 0, prev = 0, number = 0;
        char sign = '+';

        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : '+';
            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) number = number * 10 + (c - '0');
            else {
                if (sign == '+') {
                    total += prev; 
                    prev = number;
                } else if (sign == '-') {
                    total += prev;
                    prev = -number;
                } else if (sign == '*') prev *= number;
                else prev /= number;
                sign = c;
                number = 0;
            }
        }

        return total + prev;
    }
}