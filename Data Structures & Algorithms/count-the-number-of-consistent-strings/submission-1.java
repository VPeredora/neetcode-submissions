class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int amount = words.length;
        Set<Character> allowedSet = new HashSet<>(allowed.length());
        
        for (char c : allowed.toCharArray())
            allowedSet.add(c);

        for (String word : words) {
            for (char c : word.toCharArray())
                if (!allowedSet.contains(c)) {
                    amount--;
                    break;
                }
        }

        return amount;
    }
}