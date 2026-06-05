class Solution {
    public List<String> commonChars(String[] words) {
        int[] frequency = new int[26];
        Arrays.fill(frequency, Integer.MAX_VALUE);

        for (String word : words) {
            int[] temp = new int[26];
            for (char c : word.toCharArray())
                temp[c - 'a']++;
            
            for (int i = 0; i < 26; i++)
                frequency[i] = Math.min(temp[i], frequency[i]);
        }

        List<String> common = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            for (int j = frequency[i]; j > 0; j--)
                common.add(String.valueOf((char) (i + 'a')));

        return common;
    }
}