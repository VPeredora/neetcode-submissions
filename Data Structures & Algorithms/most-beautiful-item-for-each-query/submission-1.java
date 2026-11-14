class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < queries.length; i++) {
            int budget = queries[i];

            for (int j = 0; j < items.length; j++) {
                if (items[j][0] > budget) break;
                result[i] = Math.max(result[i], items[j][1]);
            }
        }

        return result;
    }
}
