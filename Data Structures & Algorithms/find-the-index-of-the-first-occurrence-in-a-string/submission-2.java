class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int N = needle.length();
        int[] lps = new int[N];
        int i = 1, prevLPS = 0;

        while (i < N) {
            if (needle.charAt(i) == needle.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++; i++;
            } else if (prevLPS == 0) {
                lps[i] = 0;
                i++;
            } else prevLPS = lps[prevLPS - 1];
        }

        int j = i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) { i++; j++; } 
            else if (j == 0) i++;
            else j = lps[j - 1];

            if (j == N) return i - N;
        }

        return -1;
    }
}