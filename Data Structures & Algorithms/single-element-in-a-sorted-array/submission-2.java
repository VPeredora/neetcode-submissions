class Solution {
    public int singleNonDuplicate(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) || 
                (i < nums.length - 1 && nums[i] == nums[i + 1])) continue;
            return nums[i];
        }

        return -1;
    }
}