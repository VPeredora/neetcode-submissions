class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int length = 1, curLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] || 
               (nums[i - curLen] < nums[i - curLen + 1]) != (nums[i - 1] < nums[i])) {
                curLen = (nums[i] == nums[i - 1]) ? 1 : 2;
                continue;
            }
            curLen++;
            length = Math.max(length, curLen);
        }

        return length;
    }
}