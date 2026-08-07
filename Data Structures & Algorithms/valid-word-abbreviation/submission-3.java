class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;

        while (i < abbr.length() && j < word.length()) {
            char c = abbr.charAt(i);

            if (Character.isLetter(c)) {
                if (c != word.charAt(j)) return false;
                i++; j++;
            } else if (Character.isDigit(c)) {
                if (c == '0') return false;
                StringBuilder number = new StringBuilder(c);

                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) 
                    number.append(abbr.charAt(i++));
                int num = Integer.parseInt(number.toString());
                j += num;

                if (j > word.length()) return false;
            }
        }

        return i == abbr.length();
    }
}