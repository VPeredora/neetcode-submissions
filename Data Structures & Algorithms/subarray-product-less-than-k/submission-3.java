class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, result = 0;
        double prod = 1;

        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];

            while (l <= r && prod >= k) 
                prod /= nums[l++];

            result += r - l + 1;
        }

        return result;
    }
}