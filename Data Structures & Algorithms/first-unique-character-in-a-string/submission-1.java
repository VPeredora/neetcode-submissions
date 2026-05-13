class Solution {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];
        
        for (char c : s.toCharArray())
            frequency[c - 'a']++;
        
        for (char c : s.toCharArray())
            if (frequency[c - 'a'] == 1) return s.indexOf(c);

        return -1;
    }
}