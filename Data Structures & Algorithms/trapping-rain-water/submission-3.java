class Solution {
    public int trap(int[] height) {
        int N = height.length;
        if (N == 0) return 0;
        
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        leftMax[0] = height[0];
        rightMax[N - 1] = height[N - 1];
        for (int i = 1, j = N - 2; i < N && j >= 0; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int amount = 0;
        for (int i = 0; i < N; i++)
            amount += Math.min(leftMax[i], rightMax[i]) - height[i];

        return amount;
    }
}
