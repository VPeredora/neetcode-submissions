class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l == r) return l;
        int mid = l + (r - l) / 2;

        if (nums[mid] > nums[mid + 1]) return binarySearch(nums, l, mid);
        return binarySearch(nums, mid + 1, r);
    }
}