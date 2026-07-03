class Solution {
    public String customSortString(String order, String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray())
            frequency[c - 'a']++;

        StringBuilder result = new StringBuilder(s.length());
        for (char c : order.toCharArray())
            while (frequency[c - 'a']-- > 0) result.append(c);
        
        for (int i = 0; i < 26; i++)
            while (frequency[i]-- > 0) result.append((char) (i + 'a'));

        return result.toString();
    }
}