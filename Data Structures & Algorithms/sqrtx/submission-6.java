class Solution {
    public int mySqrt(int x) {
        int l = 0, r = (x >> 1) + 1;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long mult = (long) mid * mid;

            if (mult == x) return mid;
            else if (mult > x) r = mid - 1;
            else if (mult < x) {
                l = mid + 1;
                result = mid;
            }
        }

        return result;
    }
}