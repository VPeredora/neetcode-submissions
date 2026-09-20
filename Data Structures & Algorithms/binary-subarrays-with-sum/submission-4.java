class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal - 1);
    }

    private int count(int[] nums, int goal) {
        if (goal < 0) return 0;
        int result = 0, l = 0, current = 0;

        for (int r = 0; r < nums.length; r++) {
            current += nums[r];
            
            while (current > goal)
                current -= nums[l++];
            
            result += (r - l + 1);
        }

        return result;
    }
}