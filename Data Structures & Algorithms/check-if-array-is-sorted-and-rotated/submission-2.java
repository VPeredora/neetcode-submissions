class Solution {
    public boolean check(int[] nums) {
        int x = 0, N = nums.length;

        for (int i = 0; i < N - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                for (int j = i + 1; j < N - 1; j++) {
                    if (j == N - 2 && nums[j + 1] > nums[0]) return false;
                    if (nums[j] > nums[j + 1]) return false;
                }
                return true;
            }
        }

        return true;
    }
}