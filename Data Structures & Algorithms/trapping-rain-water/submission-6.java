class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int amount = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[++l]);
                amount += leftMax - height[l];
            } else {
                rightMax = Math.max(rightMax, height[--r]);
                amount += rightMax - height[r];
            }
        }

        return amount;
    }
}
