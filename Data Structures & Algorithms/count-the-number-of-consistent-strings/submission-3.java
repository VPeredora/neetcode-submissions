class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int amount = words.length, bitMask = 0;
        
        for (char c : allowed.toCharArray())
            bitMask |= 1 << (c - 'a');

        for (String word : words)
            for (char c : word.toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((bit & bitMask) == 0) {
                    amount--;
                    break;
                }
            }

        return amount;
    }
}