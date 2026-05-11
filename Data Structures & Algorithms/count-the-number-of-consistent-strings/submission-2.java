class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int amount = words.length;
        boolean[] allowedChars = new boolean[26];
        
        for (char c : allowed.toCharArray())
            allowedChars[c - 'a'] = true;

        for (String word : words)
            for (char c : word.toCharArray())
                if (!allowedChars[c - 'a']) {
                    amount--;
                    break;
                }

        return amount;
    }
}