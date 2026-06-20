class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> bars = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!bars.isEmpty() && bars.peek()[1] >= heights[i]) {
                int[] bar = bars.pop();
                maxArea = Math.max(maxArea, bar[1] * (i - bar[0]));
                start = bar[0];
            }

            bars.push(new int[] {start, heights[i]});
        }

        for (int[] bar : bars)
            maxArea = Math.max(maxArea, (heights.length - bar[0]) * bar[1]);

        return maxArea;
    }
}
