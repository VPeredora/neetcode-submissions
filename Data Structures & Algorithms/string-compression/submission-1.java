class Solution {
    public int compress(char[] chars) {
        int l = 0, r = 0, k = 0;

        while (l < chars.length) {
            chars[k++] = chars[l];
            r = l + 1;
            while (r < chars.length && chars[l] == chars[r]) r++;

            if (r - l > 1) {
                String number = String.valueOf(r - l);
                for (char c : number.toCharArray())
                    chars[k++] = c;
            }
            l = r;
        }

        return k;
    }
}