class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int leastCap = Arrays.stream(weights).max().getAsInt();

        while (true) {
            int loadDays = 1, loadWeight = 0;

            for (int weight : weights) {
                if (loadWeight + weight > leastCap) {
                    loadDays++;
                    loadWeight = 0;
                }
                loadWeight += weight;
            }

            if (loadDays <= days) return leastCap;
            leastCap++;
        }
    }
}