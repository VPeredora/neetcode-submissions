class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k %= N;

        int[] rotated = Arrays.copyOfRange(nums, N - k, N);
        System.arraycopy(nums, 0, nums, k % N, N - k);
        System.arraycopy(rotated, 0, nums, 0, rotated.length);
    }
}