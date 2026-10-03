class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x / 2 + 1;
        long result = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long mult = mid * mid;

            if (mult == x) return (int) mid;
            else if (mult < x) {
                l = mid + 1;
                result = mid;
            }
            else if (mult > x) r = mid - 1;
        }

        return (int) result;
    }
}