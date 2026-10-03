class Solution {
    public int mySqrt(int x) {
        int result = 0;

        for (int i = 0; i <= x / 2 + 1; i++) {
            if ((long) i * i > x) break;
            result = i;
        }

        return result;
    }
}