class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        List<StringBuilder> line = new ArrayList<>();
        int lineLength = 0;
        
        for (int i = 0; i < words.length;) {
            if (lineLength + line.size() + words[i].length() <= maxWidth) {
                lineLength += words[i].length();
                line.add(new StringBuilder(words[i]));
                i++;
            } else {
                int totalSpaces = maxWidth - lineLength;
                int spaces = totalSpaces / Math.max(line.size() - 1, 1);
                int remainder = totalSpaces % Math.max(line.size() - 1, 1);

                for (int j = 0; j < Math.max(line.size() - 1, 1); j++) {
                    int whitespaces = remainder-- > 0 ? spaces + 1 : spaces;
                    line.set(j, line.get(j).repeat(' ', whitespaces));
                }

                output.add(String.join("", line));
                line.clear();
                lineLength = 0;
            }
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", line));
        int extraSpaces = maxWidth - lastLine.length();
        lastLine.repeat(' ', extraSpaces);
        output.add(lastLine.toString());
        
        return output;
    }
}