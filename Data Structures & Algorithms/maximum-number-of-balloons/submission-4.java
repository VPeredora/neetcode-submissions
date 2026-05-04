class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : text.toCharArray())
            if ("balon".indexOf(c) != -1)
                frequency.merge(c, 1, Integer::sum);
            
        if (frequency.size() == 5) {
            frequency.replace('l', frequency.get('l') / 2);
            frequency.replace('o', frequency.get('o') / 2);
            return Collections.min(frequency.values());
        }

        return 0;
    }
}