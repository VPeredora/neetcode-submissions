class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] frequency = new int[26];
        for (char c : chars.toCharArray())
            frequency[c - 'a']++;

        int[] temp = frequency.clone();
        int sum = 0;

        for (String word : words) {
            boolean same = true;
            
            for (char c : word.toCharArray()) {
                if (--temp[c - 'a'] < 0) {
                    same = false;
                    break;
                }
            }

            if (same) sum += word.length();
            for (int i = 0; i < 26; i++)
                temp[i] = frequency[i];
        }

        return sum;
    }
}