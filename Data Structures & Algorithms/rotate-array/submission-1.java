class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int N = nums.length;
        
        for (int i = 0; i < N; i++)
            result[(i + k) % N] = nums[i];

        for (int i = 0; i < N; i++)
            nums[i] = result[i];
    }
}