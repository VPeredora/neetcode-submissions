class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int result = 0;

        while (l < r) {
            int amount = (r - l) * Math.min(heights[l], heights[r]);
            result = Math.max(result, amount);

            if (heights[l] > heights[r]) r--;
            else if (heights[l] <= heights[r]) l++;
        }

        return result;
    }
}
