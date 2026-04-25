class Solution {
    public int maxDifference(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray())
            frequency[c - 'a']++;

        int maxOdd = 0, minEven = 0;
        for (int i : frequency) {
            if (i != 0) {
                maxOdd = i % 2 != 0 && i > maxOdd ? i : maxOdd;
                minEven = i % 2 == 0 && (minEven != 0 && i < minEven || minEven == 0) ? i : minEven;
            }
        }

        return maxOdd - minEven;
    }
}