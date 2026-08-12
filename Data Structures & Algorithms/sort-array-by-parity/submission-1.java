class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for (int l = 0, r = 0; r < nums.length; r++)
            if ((nums[r] & 1) == 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l++] = temp;
            }

        return nums;
    }
}