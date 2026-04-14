class Solution {
    public int lengthOfLastWord(String s) {
        int start = 0, end = s.length() - 1;
        while (end >= 0 && start >= 0) {
            if (Character.isLetterOrDigit(s.charAt(end))) {
                start = end;
                while (start >= 0 && Character.isLetterOrDigit(s.charAt(start))) start--;
                return end - start;
            }
            end--;
        }
        return 0;
    }
}