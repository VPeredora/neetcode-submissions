class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = ranks[0];

        for (int rank : ranks)
            maxRank = Math.max(maxRank, rank);

        long l = 1, r = maxRank * (long) cars * cars;

        while (l < r) {
            long mid = l + (r - l) / 2;
            long numCars = 0;

            for (int rank : ranks) {
                numCars += Math.sqrt(mid / rank);
                if (numCars > cars) break;
            }

            if (numCars >= cars) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
