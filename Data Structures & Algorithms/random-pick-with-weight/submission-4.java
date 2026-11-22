class Solution {
    private int[] prefix;
    
    public Solution(int[] w) {
        prefix = new int[w.length + 1];

        for (int i = 0; i < w.length; i++)
            prefix[i + 1] = prefix[i] + w[i];
    }

    public int pickIndex() {
        double randNum = prefix[prefix.length - 1] * Math.random();
        int l = 1, r = prefix.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (prefix[mid] > randNum) r = mid;
            else if (prefix[mid] <= randNum) l = mid + 1;
        }

        return l - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */