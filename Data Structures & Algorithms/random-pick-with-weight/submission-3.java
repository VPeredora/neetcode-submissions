class Solution {
    private int[] prefix;
    private int total = 0;
    
    public Solution(int[] w) {
        prefix = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            total += w[i];
            prefix[i] = total;
        }
    }

    public int pickIndex() {
        double randNum = total * Math.random();
        int l = 0, r = prefix.length - 1;
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (prefix[mid] > randNum) {
                result = mid; r = mid - 1;
            } else if (prefix[mid] <= randNum) l = mid + 1;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */