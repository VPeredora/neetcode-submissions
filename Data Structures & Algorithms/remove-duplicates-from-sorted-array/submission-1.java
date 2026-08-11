class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int r = 1; r < nums.length; r++)
            if (nums[k - 1] != nums[r])
                nums[k++] = nums[r];  

        return k;
    }
}