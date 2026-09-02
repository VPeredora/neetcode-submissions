class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray())
            count[c - 'a']++;
        
        for (int l = 0; l < s2.length(); l++) {
            if (count[s2.charAt(l) - 'a'] > 0) {
                int[] count2 = new int[26];

                for (int r = l; r < s2.length(); r++) {
                    char c = s2.charAt(r);
                    count2[c - 'a']++;

                    if (count2[c - 'a'] > count[c - 'a']) break;
                    if (r - l + 1 == s1.length()) return true;
                }
            }
        }
        
        return false;
    }
}
