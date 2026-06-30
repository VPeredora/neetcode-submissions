class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length + 1];

        for (int i = 0; i < words.length; i++)
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);

        int[] answer = new int[queries.length];
        
        for (int i = 0; i < answer.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            answer[i] = prefix[ri + 1] - prefix[li];
        }
            
        return answer;
    }

    private boolean isVowelString(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);

        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}