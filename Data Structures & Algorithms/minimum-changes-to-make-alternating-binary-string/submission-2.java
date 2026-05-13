class Solution {
    public int minOperations(String s) {
        int operations = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') operations++;
            } else if (s.charAt(i) == '0') operations++;
        }

        return Math.min(operations, s.length() - operations);
    }
}