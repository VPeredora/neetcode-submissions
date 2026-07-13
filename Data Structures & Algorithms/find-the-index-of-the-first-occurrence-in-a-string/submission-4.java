class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int base1 = 31, mod1 = 768258391;
        int base2 = 37, mod2 = 685683731;

        int N = haystack.length(), M = needle.length();
        if (M > N) return -1;

        long power1 = 1, power2 = 1;
        for (int i = 0; i < M; i++) {
            power1 = (power1 * base1) % mod1;
            power2 = (power2 * base2) % mod2;
        }
        
        long needleHash1 = 0, needleHash2 = 0;
        long haystackHash1 = 0, haystackHash2 = 0;

        for (int i = 0; i < M; i++) {
            needleHash1 = (needleHash1 * base1 + needle.charAt(i)) % mod1;
            needleHash2 = (needleHash2 * base2 + needle.charAt(i)) % mod2;
            haystackHash1 = (haystackHash1 * base1 + haystack.charAt(i)) % mod1;
            haystackHash2 = (haystackHash2 * base2 + haystack.charAt(i)) % mod2;
        }

        for (int i = 0; i <= N - M; i++) {
            if (haystackHash1 == needleHash1 && haystackHash2 == needleHash2)
                return i;
            
            if (i + M < N) {
                haystackHash1 = (haystackHash1 * base1 - haystack.charAt(i) * power1 + haystack.charAt(i + M)) % mod1;
                haystackHash2 = (haystackHash2 * base2 - haystack.charAt(i) * power2 + haystack.charAt(i + M)) % mod2;

                if (haystackHash1 < 0) haystackHash1 += mod1;
                if (haystackHash2 < 0) haystackHash2 += mod2;
            }

        }        

        return -1;
    }
}