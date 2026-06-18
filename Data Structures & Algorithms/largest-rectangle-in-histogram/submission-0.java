class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxSquare = 0;

        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];

            int leftBars = 0;
            for (int j = i - 1; j >= 0; j--)
                if (heights[j] < minHeight) break;
                else leftBars++;
            
            int rightBars = 0;
            for (int k = i + 1; k < heights.length; k++)
                if (heights[k] < minHeight) break;
                else rightBars++;
            
            int currentSquare = minHeight * (leftBars + 1 + rightBars);
            maxSquare = Math.max(maxSquare, currentSquare);
        }

        return maxSquare;
    }
}
