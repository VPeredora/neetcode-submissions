class Solution {
    public String largestGoodInteger(String num) {
        String largest = "";

        for (int i = 0; i < num.length() - 2; i++) {
            String substring = num.substring(i, i + 3);
            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2))
                largest = largest.length() < 3 ? substring : 
                    String.valueOf(Math.max(Integer.valueOf(substring), Integer.valueOf(largest)));
        }

        return largest;
    }
}