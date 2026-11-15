class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> { return Integer.compare(a[0], b[0]); });
        int[] best = new int[items.length];
        int maxBeauty = 0;

        for (int i = 0; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            best[i] = maxBeauty;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0, r = items.length;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (items[mid][0] > queries[i]) r = mid;
                else l = mid + 1;
            }

            result[i] = l == 0 ? 0 : best[l - 1];
        }
            
        return result;
    }
}
