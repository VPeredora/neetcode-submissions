class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int N = nums.length - 1;
        int l = 0, r = N;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                int start = mid, end = mid;

                while (start > 0 && nums[start] == target) start--;
                while (end < N && nums[end] == target) end++;

                result[0] = nums[start] == target ? 0 : start + 1;
                result[1] = nums[end] == target ? N : end - 1;

                break;
            } else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return result;
    }
}