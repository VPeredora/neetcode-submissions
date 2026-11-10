class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findLeft(nums, target);

        if (start == -1) return new int[]{-1, -1};

        int end = findRight(nums, target);

        return new int[]{start, end};
    }

    private int findLeft(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) return -1;

        while (idx > 0 && nums[idx - 1] == target) idx--;

        return idx;
    }

    private int findRight(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) return -1;

        while (idx < nums.length - 1 && nums[idx + 1] == target) idx++;

        return idx;
    }
}