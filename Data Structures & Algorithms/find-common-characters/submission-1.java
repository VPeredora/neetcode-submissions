class Solution {
    public List<String> commonChars(String[] words) {
        int[] frequency = new int[26];
        for (char c : words[0].toCharArray())
            frequency[c - 'a']++;
        
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (frequency[j] > 0) {
                    int index = 0;
                    for (int k = 1; k <= frequency[j]; k++) {
                        index = words[i].indexOf(j + 'a', index);
                        if (index == -1) {frequency[j] = k - 1; break;}
                        index++; 
                    }
                }
            } 
        }
        
        List<String> common = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < frequency[i]; j++)
                common.add(String.valueOf((char) (i + 'a')));

        return common;
    }
}