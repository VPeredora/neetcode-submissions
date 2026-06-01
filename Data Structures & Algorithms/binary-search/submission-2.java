class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int middle = left + ((right - left) / 2);
            if (target <= nums[middle]) {
                right = middle;
            } else left = middle + 1;
        }

        return (left < nums.length && nums[left] == target) ? left : -1;
    }
}
