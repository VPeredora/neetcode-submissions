class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, longest = 0;
        Map<Character, Integer> unique = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);

            if (unique.containsKey(c) && unique.get(c) >= l) {
                longest = Math.max(longest, r - l);
                l = unique.get(c) + 1;
            } 

            unique.put(c, r);
            r++;
        }

        longest = Math.max(longest, r - l);

        return longest;
    }
}
