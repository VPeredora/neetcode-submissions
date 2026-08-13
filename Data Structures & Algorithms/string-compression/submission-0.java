class Solution {
    private int l = 0, r = 1, amount = 1;

    public int compress(char[] chars) {
        while (r < chars.length) {
            if (chars[r - 1] != chars[r]) {
                compressLetter(chars, chars[r - 1]);
            } else amount++;
            r++;
        }
        compressLetter(chars, chars[r - 1]);

        return l;
    }

    private void compressLetter(char[] chars, char c) {
        chars[l++] = c;

        if (amount > 1) {
            String number = String.valueOf(amount);
            
            for (char ch : number.toCharArray())
                chars[l++] = ch;

            amount = 1;
        }
    }
}