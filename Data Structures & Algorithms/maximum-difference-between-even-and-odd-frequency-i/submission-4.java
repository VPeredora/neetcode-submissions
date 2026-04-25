class Solution {
    public int maxDifference(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray())
            frequency[c - 'a']++;

        int maxOdd = 0, minEven = s.length();
        for (int i : frequency) {
            if (i != 0 && (i & 1) == 1) maxOdd = Math.max(i, maxOdd);
            if (i != 0 && (i & 1) == 0) minEven = Math.min(i, minEven);
        }

        return maxOdd - minEven;
    }
}