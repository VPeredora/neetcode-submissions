class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);

        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target, boolean leftSearch) {
        int l = 0, r = nums.length - 1;
        int idx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else {
                idx = mid;
                if (leftSearch) r = mid - 1;
                else l = mid + 1;
            }
        }

        return idx;
    }
}