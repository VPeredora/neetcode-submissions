class Solution {
    public boolean check(int[] nums) {
        int N = nums.length, breakPoint = 0;

        for (int i = 0; i < N - 1; i++) {
            if (i == N - 2 && breakPoint == 1 && nums[0] < nums[N - 1]) return false;
            if (nums[i] > nums[i + 1] && ++breakPoint > 1) return false;
        }

        return true;
    }
}