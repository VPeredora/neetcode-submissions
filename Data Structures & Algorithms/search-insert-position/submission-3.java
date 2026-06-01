class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length, middle = 0;

        while (left < right) {
            middle = left + ((right - left) / 2);

            if (target <= nums[middle]) right = middle;
            else left = middle + 1;
        }

        return left;
    }
}
