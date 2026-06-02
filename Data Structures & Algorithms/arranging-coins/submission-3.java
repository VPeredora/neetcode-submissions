class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n, rows = 0;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            long coins = (long) mid * (mid + 1) / 2;

            if (coins <= n) {
                rows = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return rows;
    }
}