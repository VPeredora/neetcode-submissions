class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1, N = s.length();

        for (int i = 0; i < N; i++)
            for (int j = N - 1; j > i; j--)
                if (s.charAt(i) == s.charAt(j)) {
                    maxLength = Math.max(maxLength, j - i - 1);
                    break;
                }

        return maxLength;
    }
}