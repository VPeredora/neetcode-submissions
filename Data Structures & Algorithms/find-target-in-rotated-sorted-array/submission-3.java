class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) r = mid;
            else l = mid + 1;
        }

        int left = 0, right = nums.length - 1;

        if (target > nums[right]) right = l - 1;
        else left = l;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) return mid;
            else if (target <  nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
