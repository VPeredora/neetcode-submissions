class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        String s = String.join("$", needle, haystack);
        int N = s.length();
        int[] z = new int[N];
        int l = 0, r = 0;

        for (int i = 1; i < N; i++) {
            if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);

            while (i + z[i] < N && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;
            
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        for (int i = needle.length() + 1; i < N; i++)
            if (z[i] == needle.length()) 
                return i - needle.length() - 1;
        
        return -1;
    }
}