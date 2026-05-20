class Solution {
    public int longestPalindrome(String s) {
        int lowercase = 0, uppercase = 0, length = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int bit = 1 << (c - 'a');
                if ((lowercase & bit) != 0) length += 2;
                lowercase ^= bit;
            } else {
                int bit = 1 << (c - 'A');
                if ((uppercase & bit) != 0) length += 2;
                uppercase ^= bit;
            }
        }

        return (lowercase > 0 || uppercase > 0) ? length + 1 : length;
    }
}