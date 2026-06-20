class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> bars = new ArrayDeque<>();
        int maxArea = 0, N = heights.length;

        for (int i = 0; i <= N; i++) {
            while (!bars.isEmpty() && (i == N || heights[bars.peek()] >= heights[i])) {
                int height = heights[bars.pop()];
                int width = bars.isEmpty() ? i : i - bars.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            bars.push(i);
        }

        return maxArea;
    }
}
