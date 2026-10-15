class Solution {
    public int minimizeMax(int[] nums, int p) {
        int N = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[p + 1];
        int[] dp1 = new int[p + 1];
        int[] dp2 = new int[p + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(dp1, Integer.MAX_VALUE);
        Arrays.fill(dp2, Integer.MAX_VALUE);

        dp[0] = dp1[0] = dp2[0] = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int pairs = 1; pairs <= p; pairs++) {
                int take = Integer.MAX_VALUE;

                if (i + 1 < N)
                    take = Math.max(nums[i + 1] - nums[i], dp2[pairs - 1]);

                int skip = dp1[pairs];
                dp[pairs] = Math.min(take, skip);
            }

            dp2 = dp1.clone();
            dp1 = dp.clone();
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
        }

        return dp1[p];
    }
}