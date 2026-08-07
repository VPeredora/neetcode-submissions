class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, A = abbr.length(), W = word.length();

        while (i < A && j < W) {
            char c = abbr.charAt(i);
            if (c == '0') return false;

            if (Character.isLetter(c)) {
                if (c != word.charAt(j)) return false;
                i++; j++;
            } else {
                int number = 0;
                while (i < A && Character.isDigit(abbr.charAt(i)))
                    number = number * 10 + (abbr.charAt(i++) - '0');
                j += number;
            }
        }

        return i == A && j == W;
    }
}