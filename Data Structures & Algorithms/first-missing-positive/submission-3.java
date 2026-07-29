class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;

        for (int i = 0; i < N; i++)
            if (nums[i] < 0) nums[i] = 0;
        
        for (int i = 0; i < N; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= N) {
                if (nums[val - 1] > 0) 
                    nums[val - 1] *= -1;
                else if (nums[val - 1] == 0) 
                    nums[val - 1] = -1 * (N + 1);
            }
        }
        
        for (int i = 0; i < N; i++)
            if (nums[i] >= 0) return i + 1;

        return N + 1;
    }
}