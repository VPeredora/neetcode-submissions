class Solution {
    public int longestPalindrome(String s) {
        Set<Character> pairs = new HashSet<>();
        int length = 0;
        
        for (char c : s.toCharArray())
            if (!pairs.add(c)) {
                pairs.remove(c);
                length += 2;
            }

        return pairs.isEmpty() ? length : length + 1;
    }
}