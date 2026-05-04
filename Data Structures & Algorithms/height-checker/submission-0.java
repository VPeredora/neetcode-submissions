class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        int result = 0;

        Arrays.sort(expected);
        for(int i = 0; i < heights.length; i++)
            if (heights[i] != expected[i]) result++;
        
        return result;
    }
}