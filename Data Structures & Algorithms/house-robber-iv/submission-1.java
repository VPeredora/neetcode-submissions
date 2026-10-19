class Solution {
    public int minCapability(int[] nums, int k) {
        int l = nums[0], r = nums[0];

        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int houses = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) { houses++; i++; }
                if (houses == k) break; 
            }

            if (houses == k) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
