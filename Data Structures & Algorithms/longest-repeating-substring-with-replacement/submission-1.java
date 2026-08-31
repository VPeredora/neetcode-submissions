class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        Set<Character> unique = new HashSet<>();
        for (char c : s.toCharArray())
            unique.add(c);
        
        for (char c : unique) {
            int maxFreq = 0, l = 0;

            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) maxFreq++;

                while ((r - l + 1) - maxFreq > k) {
                    if (s.charAt(l) == c) maxFreq--;
                    l++;
                }

                longest = Math.max(longest, r - l + 1);
            }
        }

        return longest;
    }
}
