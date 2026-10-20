class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        long l = 1, r = quantities[0];

        for (int quantity : quantities)
            r = Math.max(r, quantity);

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long stores = 0;

            for (int quantity : quantities)
                stores += (quantity + mid - 1) / mid;

            if (stores <= n) r = mid - 1;
            else l = mid + 1;
        }

        return (int) l;
    }
}
