class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int length = -1;

        for (char c : s.toCharArray()) {
            if (s.length() - s.indexOf(c) - 1 < length) return length;
            if (s.indexOf(c) < s.lastIndexOf(c)) 
                length = Math.max(length, s.lastIndexOf(c) - s.indexOf(c) - 1);
        }

        return length;
    }
}