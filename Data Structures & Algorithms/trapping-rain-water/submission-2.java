class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] prefix = new int[N];
        int[] suffix = new int[N];

        int leftMax = height[0], rightMax = height[N - 1];
        for (int i = 0, j = N - 1; i < N && j >= 0; i++, j--) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            prefix[i] = leftMax;
            suffix[j] = rightMax;
        }

        int amount = 0;

        for (int i = 0; i < N; i++)
            amount += Math.min(prefix[i], suffix[i]) - height[i];

        return amount;
    }
}
