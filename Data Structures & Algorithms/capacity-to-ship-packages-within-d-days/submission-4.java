class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l <= r) {
            int leastCap = l + (r - l) / 2;
            int loadDays = 1, loadWeight = 0;

            for (int weight : weights) {
                if (loadWeight + weight > leastCap) { loadDays++; loadWeight = 0; }
                if (loadDays > days) break;
                loadWeight += weight;
            }

            if (loadDays > days) l = leastCap + 1;
            else if (loadDays <= days) r = leastCap - 1;
        }

        return l;
    }
}