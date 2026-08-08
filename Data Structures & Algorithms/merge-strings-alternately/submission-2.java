class Solution {
    public String mergeAlternately(String word1, String word2) {
        int N = word1.length(), M = word2.length();
        StringBuilder result = new StringBuilder(N + M);

        for (int i = 0; i < N || i < M; i++) {
            if (i < N) result.append(word1.charAt(i));
            if (i < M) result.append(word2.charAt(i));
        }

        return result.toString();
    }
}