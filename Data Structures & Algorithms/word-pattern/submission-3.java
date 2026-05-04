class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> bijection = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();
        String[] words = s.split("\\s+");
        int pointer = 0;

        while (pointer < pattern.length() && pointer < words.length) {
            char letter = pattern.charAt(pointer);
            String word = bijection.putIfAbsent(letter, words[pointer]);
            if (word != null && !word.equals(words[pointer]))
                return false;
            if (word == null && !uniqueWords.add(words[pointer]))
                return false;
            pointer++;
        }

        return pattern.length() == words.length;
    }
}