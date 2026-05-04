class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : text.toCharArray())
            if ("balloon".indexOf(c) != -1)
                frequency.merge(c, 1, Integer::sum);
            
        if (frequency.size() == 5 && frequency.get('l') >= 2 && frequency.get('o') >= 2) {
            int countOfSingleChars = Math.min(frequency.get('a'), Math.min(frequency.get('b'), frequency.get('n')));
            int countOfDoubleChars = Math.min(frequency.get('l') / 2, frequency.get('o') / 2);
            return Math.min(countOfSingleChars, countOfDoubleChars);
        }

        return 0;
    }
}
