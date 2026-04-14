class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int first = 0, second = 0;

        while (first < s.length()) {
            while (second < t.length() && s.charAt(first) != t.charAt(second)) second++;
            if (second == t.length()) return false;
            first++;
            second++;
        }

        return true;
    }
}