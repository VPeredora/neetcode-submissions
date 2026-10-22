class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = nums[0];

        for (int num : nums)
            r = Math.max(r, num);

        while (l < r) {
            int mid = l + (r - l) / 2;
            long ops = 0;

            for (int num : nums)
                ops += (num - 1) / mid;

            if (ops <= maxOperations) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
