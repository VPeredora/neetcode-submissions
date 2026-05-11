class Solution {
    public int maxProductDifference(int[] nums) {
        int w = 0, x = 0, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > w) {
                x = w;
                w = num;
            } else if (num > x) x = num;
            if (num < z) {
                y = z;
                z = num;
            } else if (num < y) y = num;
        }
        
        return (w * x) - (y * z);
    }
}