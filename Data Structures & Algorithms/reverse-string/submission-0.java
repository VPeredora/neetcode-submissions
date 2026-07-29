class Solution {
    public void reverseString(char[] s) {
        int N = s.length;

        for (int i = 0; i < N / 2; i++) {
            char c = s[i];
            s[i] = s[N - 1 - i];
            s[N - 1 - i] = c;
        }
    }
}