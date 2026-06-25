class Solution {
    public String decodeString(String s) {
        Deque<String> decoded = new ArrayDeque<>();
        Deque<Integer> amount = new ArrayDeque<>();
        StringBuilder accumulated = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) k = k * 10 + (c - '0');
            else if (c == '[') {
                decoded.push(accumulated.toString());
                amount.push(k);
                accumulated.setLength(0);
                k = 0;
            }
            else if (c == ']') {
                String temp = accumulated.toString().repeat(amount.pop());
                accumulated = new StringBuilder(decoded.pop()).append(temp);
            }
            else accumulated.append(c);
        }
        
        return accumulated.toString();
    }
}