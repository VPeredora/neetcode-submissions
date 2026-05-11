class Solution {
    public int maxScore(String s) {
        int left = s.charAt(0) == '0' ? 1 : 0;
        int right = 0;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == '1') right++;

        int score = left + right;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') left++;
            else right--;
            score = Math.max(score, left + right);
        }

        return score;
    }
}