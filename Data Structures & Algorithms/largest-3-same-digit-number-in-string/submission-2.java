class Solution {
    public String largestGoodInteger(String num) {
        char largest = '\0';

        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if (num.charAt(i) > largest) largest = num.charAt(i);
                i += 2;
            }
        }

        return largest == '\0' ? "" : String.valueOf(largest).repeat(3);
    }
}
