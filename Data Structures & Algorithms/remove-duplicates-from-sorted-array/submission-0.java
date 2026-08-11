class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] != nums[l]) {
                nums[++l] = nums[r];
                k++;
            }
        }

        return k;
    }
}