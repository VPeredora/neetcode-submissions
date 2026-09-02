class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++)
            if (count[i] == window[i]) matches++;

        for (int l = 0, r = s1.length(); r < s2.length(); l++, r++) {
            if (matches == 26) return true;

            int cRight = s2.charAt(r) - 'a';
            window[cRight]++;
            if (count[cRight] == window[cRight]) matches++;
            else if (count[cRight] + 1 == window[cRight]) matches--;

            int cLeft = s2.charAt(l) - 'a';
            window[cLeft]--;
            if (count[cLeft] == window[cLeft]) matches++;
            else if (count[cLeft] - 1 == window[cLeft]) matches--;
        }

        return matches == 26;
    }
}
