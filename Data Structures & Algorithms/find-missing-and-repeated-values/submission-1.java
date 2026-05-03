class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];

        for (int[] arr : grid)
            for (int num : arr) {
                int row = (Math.abs(num) - 1) / grid.length;
                int col = (Math.abs(num) - 1) % grid.length;
                if (grid[row][col] < 0) {
                    result[0] = Math.abs(num);
                    continue;
                }
                grid[row][col] = -grid[row][col];
            }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j] > 0) {
                    result[1] = i * grid.length + j % grid.length + 1;
                    break;
                }

        return result;
    }
}