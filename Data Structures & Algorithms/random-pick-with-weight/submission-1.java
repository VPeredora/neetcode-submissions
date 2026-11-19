class Solution {
    private int[] weights;
    private int total = 0;
    
    public Solution(int[] w) {
        weights = w;
        for (int weight : w)
            total += weight;
    }

    public int pickIndex() {
        int randInt = new Random().nextInt(total);
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > randInt) return i;
        }
        
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */