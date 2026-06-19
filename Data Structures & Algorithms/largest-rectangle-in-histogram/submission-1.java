class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> bars = new ArrayDeque<>();
        bars.push(new int[] {0, heights[0]});
        int maxSquare = 0;

        for (int i = 1; i < heights.length; i++) {
            int index = i;
            while (!bars.isEmpty() && bars.peek()[1] >= heights[i]) {
                int[] bar = bars.pop();
                int square = bar[1] * (i - bar[0]);
                maxSquare = Math.max(maxSquare, square);
                index = bar[0];
            }
            bars.push(new int[] {index, heights[i]});
        }

        for (int[] bar : bars)
            maxSquare = Math.max(maxSquare, (heights.length - bar[0]) * bar[1]);

        return maxSquare;
    }
}
