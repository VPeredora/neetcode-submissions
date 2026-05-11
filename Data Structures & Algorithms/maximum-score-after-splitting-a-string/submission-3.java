class Solution {
    public int maxScore(String s) {
        int score = Integer.MIN_VALUE, zeros = 0, ones = 0;

        if (s.charAt(0) == '0') zeros++;
        else ones++;

        for (int i = 1; i < s.length(); i++) {
            score = Math.max(score, zeros - ones);
            if (s.charAt(i) == '0') zeros++;
            else ones++;
        }

        return score + ones;
    }
}