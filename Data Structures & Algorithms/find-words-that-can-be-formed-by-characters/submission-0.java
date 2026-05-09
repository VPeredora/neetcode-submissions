class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] frequency = new int[26];
        for (char c : chars.toCharArray())
            frequency[c - 'a']++;

        int sum = 0;
        for (String word : words) {
            boolean same = true;
            int[] temp = frequency.clone();
            for (char c : word.toCharArray()) {
                if (--temp[c - 'a'] < 0) {
                    same = false;
                    break;
                }
            }
            sum = same ? sum + word.length() : sum;
        }

        return sum;
    }
}