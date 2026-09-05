class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int longest = 0, sum = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            int size = r - l + 1;

            if ((nums[r] * size) - sum <= k) 
                longest = Math.max(longest, size);
            else sum -= nums[l++];
        }

        return longest;
    }
}