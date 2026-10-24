class Solution {
    public long repairCars(int[] ranks, int cars) {
        int[] counts = new int[101];
        int maxRank = ranks[0];

        for (int rank : ranks) {
            counts[rank]++;
            maxRank = Math.max(maxRank, rank);
        }
        
        long l = 1, r = 1L * maxRank * cars * cars;

        while (l < r) {
            long mid = l + (r - l) / 2;
            long repaired = 0;

            for (int rank = 1; rank <= 100; rank++) {
                if (counts[rank] == 0) continue;
                long left = 0, right = cars;

                while (left < right) {
                    long value = (left + right + 1) / 2;
                    if (rank * value * value <= mid) left = value;
                    else right = value - 1;
                }

                repaired += counts[rank] * left;
                if (repaired >= cars) break;
            }

            if (repaired >= cars) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
