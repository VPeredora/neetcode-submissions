class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int absDiff = 0, result = 0;

        for (int l = 0; l < nums.length; l++) {
            int highest = nums[l];
            int lowest = nums[l];

            for (int r = l; r < nums.length; r++) {
                highest = Math.max(highest, nums[r]);
                lowest = Math.min(lowest, nums[r]);
                absDiff = highest - lowest;

                if (absDiff > limit) break;
                result = Math.max(result, r - l + 1);;
            }            
        }

        return result;
    }
}