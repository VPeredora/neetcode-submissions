class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1, r = 0;
        int result = 0;

        for (int num : nums)
            r = Math.max(r, num);

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int houses = 0;
            int i = 0;

            while (i <= nums.length - 1) {
                if (nums[i] <= mid) { houses++; i += 2; }
                else i++;
                if (houses == k) break;
            }

            if (houses == k) { result = mid; r = mid - 1; }
            else l = mid + 1;
        }

        return result;
    }
}
