class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int maxFreq = 0, l = 0, longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.merge(c, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, count.get(c));

            while ((r - l + 1) - maxFreq > k) {
                count.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
