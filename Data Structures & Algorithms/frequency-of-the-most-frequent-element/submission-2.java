class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int longest = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int tempK = k;

            for (int j = i - 1; j >= 0; j--) {
                tempK -= nums[i] - nums[j];
                if (tempK >= 0) longest = Math.max(longest, i - j + 1);
            }
        }


        return longest;
    }
}