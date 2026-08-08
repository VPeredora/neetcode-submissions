class Solution {
    public String mergeAlternately(String word1, String word2) {
        int N = word1.length(), M = word2.length(), i = 0;
        StringBuilder result = new StringBuilder(N + M);

        while (i < N && i < M)
            result.append(word1.charAt(i)).append(word2.charAt(i++));

        if (i < N) result.append(word1.substring(i, N));
        else if (i < M) result.append(word2.substring(i, M));

        return result.toString();
    }
}