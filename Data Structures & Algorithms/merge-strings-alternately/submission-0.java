class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder(word1.length() + word2.length());
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i)).append(word2.charAt(j));
            i++; j++;
        }

        if (i < word1.length()) result.append(word1.substring(i, word1.length()));
        else if (j < word2.length()) result.append(word2.substring(j, word2.length()));

        return result.toString();
    }
}