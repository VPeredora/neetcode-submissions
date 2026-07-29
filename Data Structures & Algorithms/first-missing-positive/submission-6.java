class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            if (nums[i] <= 0 || nums[i] > N) continue;

            while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
                int index = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

        for (int i = 0; i < N; i++)
            if (nums[i] != i + 1) return i + 1;

        return N + 1;  
    }
}