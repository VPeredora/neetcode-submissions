class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        int suffix = 1;
        result[0] = 1;

        for (int i = 1; i < N; i++)
            result[i] = nums[i - 1] * result[i - 1];

        for (int i = N - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
