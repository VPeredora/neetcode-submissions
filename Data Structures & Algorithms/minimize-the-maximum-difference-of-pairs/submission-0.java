class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);

        int l = 0, r = Integer.MAX_VALUE;
        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isValid(nums, mid, p)) { result = mid; r = mid - 1; } 
            else l = mid + 1;
        }

        return result;
    }

    private boolean isValid(int[] nums, int mid, int p) {
        int cnt = 0, i = 0;

        while (i < nums.length - 1) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            if (diff <= mid) { cnt++;  i += 2; }
            else i++;

            if (cnt == p) return true;
        }

        return false;
    }
}