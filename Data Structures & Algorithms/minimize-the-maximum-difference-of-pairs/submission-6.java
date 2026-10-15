class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;

        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isValid(nums, mid, p)) { result = mid; r = mid - 1; } 
            else l = mid + 1;
        }

        return result;
    }

    private boolean isValid(int[] nums, int threshold, int p) {
        int count = 0, i = 0;

        while (i < nums.length - 1) {
            int diff = Math.abs(nums[i] - nums[i + 1]);

            if (diff <= threshold) { count++;  i += 2; }
            else i++;

            if (count == p) return true;
        }

        return false;
    }
}