class Solution {
    public int minimizeMax(int[] nums, int p) {
        int N = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[N + 1][p + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int pairs = 1; pairs <= p; pairs++) {
                int take = Integer.MAX_VALUE;

                if (i + 1 < N) 
                    take = Math.max(nums[i + 1] - nums[i], dp[i + 2][pairs - 1]);

                int skip = dp[i + 1][pairs];
                dp[i][pairs] = Math.min(take, skip);
            }
        }

        return dp[0][p];
    }
}