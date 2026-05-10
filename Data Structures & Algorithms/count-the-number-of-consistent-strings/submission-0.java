class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int amount = 0;
        Set<Character> allowedSet = new HashSet<>(allowed.length());
        
        for (char c : allowed.toCharArray())
            allowedSet.add(c);

        for (String word : words) {
            boolean consistent = true;

            for (char c : word.toCharArray())
                if (!allowedSet.contains(c)) {
                    consistent = false;
                    break;
                }

            if (consistent) amount++;
        }

        return amount;
    }
}