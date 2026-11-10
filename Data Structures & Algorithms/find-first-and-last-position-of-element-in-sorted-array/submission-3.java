class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);

        if (start == nums.length || nums[start] != target)
            return new int[]{-1, -1};

        return new int[]{start, binarySearch(nums, target + 1) - 1};
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}