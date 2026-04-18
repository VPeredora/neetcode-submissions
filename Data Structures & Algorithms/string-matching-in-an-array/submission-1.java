class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> substrings = new ArrayList<>();
        
        for (int i = 0; i < words.length - 1; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[j].contains(words[i])) {
                    substrings.add(words[i]);
                    break;
                }

        return substrings;
    }
}
