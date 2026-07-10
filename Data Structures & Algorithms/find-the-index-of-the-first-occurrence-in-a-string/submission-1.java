class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;

        while (i < haystack.length()) {
            while (i < haystack.length() && j < needle.length() && 
                haystack.charAt(i) == needle.charAt(j)) {i++; j++;}

            if (j == needle.length()) return i - j;
            i = i - j + 1;
            j = 0;
        }

        return -1;
    }
}