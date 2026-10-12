class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int leastCap = Arrays.stream(weights).max().getAsInt();

        while (true) {
            int loadDays = 0, loadWeight = 0;

            for (int weight : weights) {
                loadWeight += weight;
                if (loadWeight > leastCap) {loadDays++; loadWeight = weight;}
                else if (loadWeight == leastCap) {loadDays++; loadWeight = 0;}
            }
            if (loadWeight > 0) loadDays++;

            if (loadDays <= days) break;
            leastCap++;
        }

        return leastCap;
    }
}