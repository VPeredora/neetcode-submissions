class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int N = nums.length, result = 0;
        double[] logs = new double[N + 1];
        double logK = Math.log(k);

        for (int i = 0; i < N; i++)
            logs[i + 1] = logs[i] + Math.log(nums[i]);

        for (int i = 0; i < N; i++) {
            int l = i + 1, r = N + 1;

            while (l < r) {
                int mid = (l + r) >> 1;

                if (logs[mid] < logs[i] + logK - 1e-12) l = mid + 1;
                else r = mid;
            }

            result += l - (i + 1);
        }

        return result;
    }
}