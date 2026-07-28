class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        StringBuilder line = new StringBuilder(maxWidth);
        int lineLength = 0, wordsAmount = 0;

        for (int i = 0; i < words.length; i++) {
            if (lineLength + wordsAmount + words[i].length() <= maxWidth) {
                lineLength += words[i].length();
                wordsAmount++;
            } else {
                int spaces = maxWidth - lineLength;
                int places = Math.max(wordsAmount - 1, 1);
                int extraSpaces = spaces % places;
                int index = i - wordsAmount;

                int spacesAmount = spaces;
                while (index < i) {
                    int amount = spacesAmount > 0 ? spaces / places : 0;
                    if (extraSpaces > 0) { amount++; extraSpaces--; }
                    line.append(words[index++]).repeat(' ', amount);
                    spacesAmount -= amount;
                }

                output.add(line.toString());
                line.setLength(0);
                lineLength = words[i].length();
                wordsAmount = 1;
            }
        }

        int index = words.length - wordsAmount;
        int totalSpaces = maxWidth - lineLength;
        while (wordsAmount > 0) {
            int amount = wordsAmount == 1 ? totalSpaces : 1;
            line.append(words[index++]).repeat(' ', amount);
            wordsAmount--; totalSpaces--;
        }
        output.add(line.toString());

        return output; 
    }
}