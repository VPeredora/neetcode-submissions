class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrom(s, 0, s.length() - 1, false);
    }

    private boolean isPalindrom(String s, int l, int r, boolean isDeleted) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (isDeleted) return false;
                return isPalindrom(s, l + 1, r, true) || 
                       isPalindrom(s, l, r - 1, true);
            }
            l++; r--;
        }
        return true;
    }
}