class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, result = 0, sum = 1;

        for (int r = 0; r < nums.length; r++) {
            sum *= nums[r];

            while (sum >= k && l <= r)
                sum /= nums[l++];

            if (sum < k) result += r - l + 1;
        }

        return result;
    }
}