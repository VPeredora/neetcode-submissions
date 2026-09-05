class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, l = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            if ((r - l + 1) * nums[r] > sum + k)
                sum -= nums[l++];
        }

        return nums.length - l;
    }
}