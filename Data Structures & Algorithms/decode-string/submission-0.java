class Solution {
    private int i = 0;

    public String decodeString(String s) {
        return decodeRegion(s);
    }

    private String decodeRegion(String s) {
        StringBuilder region = new StringBuilder();
        int k = 0;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) k = k * 10 + (c - '0');
            else if (c == '[') {
                i++; 
                String result = decodeRegion(s);
                region.append(result.repeat(k));
                k = 0;
            } else if (c == ']') return region.toString();
            else region.append(c);
        }

        return region.toString();
    }
}