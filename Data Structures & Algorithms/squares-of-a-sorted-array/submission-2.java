class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0, r = nums.length - 1, index = r;

        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                 result[index] = nums[l] * nums[l++];
            else result[index] = nums[r] * nums[r--];
            index--;
        }

        return result;
    }
}