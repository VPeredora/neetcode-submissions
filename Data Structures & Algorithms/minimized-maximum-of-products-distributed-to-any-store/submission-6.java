class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 100000;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int stores = 0;

            for (int quantity : quantities) {
                stores += (quantity + mid - 1) / mid;
                if (stores > n) break;
            }
            
            if (stores <= n) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
