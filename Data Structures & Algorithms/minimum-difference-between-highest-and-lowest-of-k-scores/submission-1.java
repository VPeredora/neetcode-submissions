class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;
        int l = 0, r = k - 1;

        while (r < nums.length)
            minimum = Math.min(minimum, nums[r++] - nums[l++]);

        return minimum;
    }
}