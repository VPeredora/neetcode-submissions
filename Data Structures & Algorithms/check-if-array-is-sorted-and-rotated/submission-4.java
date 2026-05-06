class Solution {
    public boolean check(int[] nums) {
        int N = nums.length, breakPoint = 0;

        for (int i = 0; i < N; i++)
            if (nums[i] > nums[(i + 1) % N] && ++breakPoint > 1) 
                return false;

        return true;
    }
}