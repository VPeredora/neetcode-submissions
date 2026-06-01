class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle = 0;

        while (left <= right) {
            middle = left + ((right - left) / 2);
            if (nums[middle] == target) return middle;

            if (target < nums[middle]) right = middle - 1;
            else left = middle + 1;
        }
        
        return nums[middle] > target ? middle : middle + 1;
    }
}