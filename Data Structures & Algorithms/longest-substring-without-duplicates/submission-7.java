class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> unique = new HashMap<>();
        int l = 0, longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (unique.containsKey(c))
                l = Math.max(unique.get(c) + 1, l);

            unique.put(c, r);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
