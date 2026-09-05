class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, longest = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];

            while ((nums[r] * (r - l + 1)) - sum > k)
                sum -= nums[l++];

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}