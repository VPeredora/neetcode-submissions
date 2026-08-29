class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, longest = 0;

        while (l < s.length()) {
            Set<Character> unique = new HashSet<>();
            while (r < s.length() && unique.add(s.charAt(r))) r++;

            longest = Math.max(longest, r - l);
            l++; r = l;
        }

        return longest;
    }
}
